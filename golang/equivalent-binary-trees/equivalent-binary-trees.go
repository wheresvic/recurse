package main

// https://tour.golang.org/concurrency/8

import (
	"fmt"

	"golang.org/x/tour/tree"
)

// WalkHelper ...
func WalkHelper(t *tree.Tree, ch chan int, root *tree.Tree) {
	tl := t.Left

	if tl != nil {
		WalkHelper(tl, ch, root)
	}

	ch <- t.Value

	tr := t.Right
	if tr != nil {
		WalkHelper(tr, ch, root)
	}

	if t == root {
		close(ch)
	}
}

// Walk walks the tree t sending all values
// from the tree to the channel ch.
func Walk(t *tree.Tree, ch chan int) {
	WalkHelper(t, ch, t)
}

// Same determines whether the trees
// t1 and t2 contain the same values.
func Same(t1, t2 *tree.Tree) bool {
	ch1 := make(chan int)
	ch2 := make(chan int)

	go Walk(t1, ch1)
	go Walk(t2, ch2)

	for i := 0; i <= 10; i++ {
		a := <-ch1
		b := <-ch2

		if a != b {
			return false
		}
	}

	return true
}

func main() {
	ch := make(chan int)
	t := tree.New(1)
	fmt.Print(t)
	fmt.Println("")

	go Walk(t, ch)

	/*
		for {
			select {
				case i := <-ch:
				fmt.Println(i)
				if (i == 10) {
					close(ch)
					return
				}
			}
		}
	*/

	for i := range ch {
		fmt.Println(i)
	}

	fmt.Println(Same(tree.New(1), tree.New(1)))
	fmt.Println(Same(tree.New(1), tree.New(2)))
}
