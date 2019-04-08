package main

import (
	"fmt"
	"log"
	"sync"
)

var data = make(map[string]int)
var mutex = &sync.Mutex{}

func main() {
	fmt.Println("Hello World")

	UpdateMap("a", 1)
	UpdateMap("b", 2)
	UpdateMapBetter("c", 3)
	UpdateMapBest("d", 4)
}

// UpdateMap ...
func UpdateMap(key string, value int) int {
	result := 0
	mutex.Lock()
	data[key] = value

	for _, v := range data {
		result += v
	}
	mutex.Unlock()
	log.Printf("calculated result %d", result)
	return result
}

// UpdateMapBetter ..
func UpdateMapBetter(key string, value int) int {
	result := 0
	mutex.Lock()
	defer mutex.Unlock()
	data[key] = value

	for _, v := range data {
		result += v
	}

	log.Printf("calculated result %d", result)
	return result
}

// UpdateMapBest ...
func UpdateMapBest(key string, value int) int {
	result := 0

	func() {
		mutex.Lock()
		defer mutex.Unlock()
		data[key] = value

		for _, v := range data {
			result += v
		}
	}()

	log.Printf("calculated result %d", result)
	return result
}
