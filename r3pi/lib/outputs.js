'use strict';

const fs = require('fs');
const receipt = require('receipt');
const moment = require('moment');
const Chance = require('chance');
const chance = new Chance();

const products = require('./products');
const discounts = require('./discounts');

const asciiLogoArray = fs.readFileSync(__dirname + '/../res/r3pi-ascii.txt').toString().split('\n');

receipt.config.currency = '£';
receipt.config.width = asciiLogoArray[0].length + 10;
receipt.config.ruler = '-';

function getLineitems(cart) {
  let lines = [];
  let items = cart.getItems();

  for (let itemId in items) {
    let item = items[itemId];
    let price = products[item.id].price;
    let lineItem = {
      item: products[item.id].name,
      qty: item.qty,
      cost: price
    }

    if (discounts[item.id] === '3-for-2') {
      lineItem.discount = {
        type: 'absolute',
        value: cart.getDiscountAmount(item, discounts, price),
        message: discounts[item.id]
      };
    }

    lines.push(lineItem);
  }

  return lines;
}

function getFormattedAmount(amt) {
  return amt.toLocaleString('en-GB', { style: 'currency', currency: 'GBP', maximumFractionDigits: 2 });
}

const getReceiptTextOutput = function(cart) {

  const lineItems = getLineitems(cart);
  const totalQuantity = cart.getTotalQuantity();
  const total = cart.getTotal(products, discounts) / 100;
  const gst = total / 10;
  const totalWithTax = total + gst;

  const output = receipt.create([
    { type: 'empty' },
    { type: 'text', value: asciiLogoArray, align: 'center' },
    { type: 'empty' },
    {
      type: 'properties',
      lines: [
        { name: 'Order Number', value: chance.ssn() },
        { name: 'Date', value: moment().format('DD MMMM YYYY, h:mm:ss a') }
      ]
    },
    { type: 'empty' },
    {
      type: 'table',
      lines: lineItems
    },
    { type: 'empty' },
    { type: 'empty' },
    {
      type: 'properties',
      lines: [
        { name: 'Items total quantity', value: totalQuantity },
        { name: 'Items total', value: getFormattedAmount(total) },
        { name: 'GST (10.00%)', value: getFormattedAmount(gst) },
        { name: 'Total amount (incl. GST)', value: getFormattedAmount(totalWithTax) }
      ]
    },
    { type: 'empty' },
    { type: 'empty' },
    { type: 'text', value: 'Thank you for checking out this exercise!', align: 'center', padding: 5 }
  ]);

  return output;
}

module.exports.getReceiptTextOutput = getReceiptTextOutput;
