// If you cannot use division then just subtract in a loop? Or is there another operator?

function main() {
  console.log(arrayNumberProduct([1, 2, 3, 4, 5]));
  console.log(arrayNumberProduct([3, 2, 1]));
}

function arrayNumberProduct(input) {
  let total = 1;
  const result = [];

  for (const num of input) {
    total *= num;
  }

  for (const num of input) {
    const val = total / num;
    result.push(val);
  }

  return result;
}

main();
