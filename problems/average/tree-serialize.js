// This looks to be tricky :(

function main() {
  const root = new Node(
    "root",
    new Node("left", new Node("left.left")),
    new Node("right", null, new Node("right.right"))
  );

  const serialized = serialize(root);
  console.log(serialized);
  console.log(deserialize(serialized));
}

function serialize(node) {
  let current = node;
  const result = [],
    stack = [];

  if (!current) {
    result.push("null");
    return result;
  }

  result.push(current.value);
  stack.push(current);

  let level = 0;
  let index = 0;

  while (stack.length) {
    current = stack.shift();

    if (stack.length === 0) {
      ++level;
    }

    const left = current.left;
    const right = current.right;

    if (left) {
      result.push(left.value + "," + (Math.pow(2, level) - 1) + "," + index);
      stack.push(left);
    } else {
      result.push("null" + "," + (Math.pow(2, level) - 1) + "," + index);
    }

    if (right) {
      result.push(right.value + "," + (Math.pow(2, level) - 1) + "," + index);
      stack.push(right);
    } else {
      result.push("null" + "," + (Math.pow(2, level) - 1) + "," + index);
    }

    index++;
  }

  return result;
}

function deserialize(serializedTree) {
  // TODO:
  return [];
}

class Node {
  constructor(value, left = null, right = null) {
    this.value = value;
    this.left = left;
    this.right = right;
  }
}

main();
