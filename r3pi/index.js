'use strict';

const Chance = require('chance');
const chance = new Chance();

const Cart = require('./lib/Cart');
const outputs = require('./lib/outputs');
const products = require('./lib/products');

// shopping cart
let cart = new Cart();

// seed cart
let inputSet = Object.keys(products);

let numItems = chance.natural({ min: 1, max: 50 });
for (let i = 0; i < numItems; ++i) {
  let index = chance.natural({ min: 0, max: 3 });
  cart.addItem(inputSet[index], 1);
}

// output cart
console.log(outputs.getReceiptTextOutput(cart));
