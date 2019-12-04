function main() {
  const trie = new Trie();

  trie.add("dear");
  // trie.print();
  trie.add("dog");
  // trie.print();
  trie.add("deal");

  trie.print();

  console.log("deal => " + trie.exists("deal"));
  console.log("deals => " + trie.exists("deals"));
  console.log("feel => " + trie.exists("feel"));
  console.log("do => " + trie.exists("do"));
  console.log("dog => " + trie.exists("dog"));
}

class Trie {
  constructor() {
    this.root = new TrieNode();
  }

  add(word) {
    let currentNode = this.root;
    for (const letter of word) {
      currentNode = currentNode.add(letter);
    }
  }

  exists(word) {
    let currentNode = this.root;
    for (const letter of word) {
      let node = currentNode.get(letter);
      if (node) {
        currentNode = node;
      } else {
        return false;
      }
    }

    return true;
  }

  print() {
    let stack = [this.root];
    while (stack.length) {
      const node = stack.pop();
      console.log(node.getLetters());
      stack = stack.concat(node.getNodes());
    }
  }
}

class TrieNode {
  constructor() {
    this.letters = new Map();
  }

  add(letter) {
    if (letter.length != 1) {
      throw new Error("Invalid letter");
    }

    let exists = this.letters.get(letter);
    if (exists) {
      return exists;
    }

    const node = new TrieNode();
    this.letters.set(letter, node);
    return node;
  }

  get(letter) {
    return this.letters.get(letter);
  }

  getLetters() {
    return getArrayFromIterable(this.letters.keys());
  }

  getNodes() {
    return getArrayFromIterable(this.letters.values());
  }
}

function getArrayFromIterable(iterable) {
  const result = [];
  for (const item of iterable) {
    result.push(item);
  }
  return result;
}

main();
