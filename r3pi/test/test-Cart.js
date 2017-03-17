'use strict';

const expect = require('chai').expect;

const Cart = require('../lib/Cart');
const products = require('../lib/products');
const discounts = require('../lib/discounts');

describe('Cart', () => {

  it('should add new items to the cart', () => {
    // given
    let cart = new Cart();

    // when
    cart.addItem('1', 2);

    // then
    let items = cart.getItems();
    expect(items['1'].id).to.equal('1');
    expect(items['1'].qty).to.equal(2);

  });

  it('should update item quantity in the cart', () => {
    // given
    let cart = new Cart();

    // when
    cart.addItem('1', 2);
    cart.addItem('1', 4);

    // then
    let items = cart.getItems();
    expect(items['1'].qty).to.equal(6);

  });

  it('should not allow adding items with invalid quantity', () => {
    // given
    let cart = new Cart();

    // when
    let fn = function() {
      cart.addItem('1', 0);
    }

    // then
    expect(fn).to.throw(Error);
  });
  
  it('should get the correct total quantity of items in the cart', () => {
    // given
    let cart = new Cart();

    // when
    cart.addItem('apple', 1);
    cart.addItem('papaya', 2);

    // then
    expect(cart.getTotalQuantity()).to.equal(3);
  });

  it('should get the correct total of items in the cart', () => {
    // given
    let cart = new Cart();
    cart.addItem('apple', 1);
    cart.addItem('orange', 2);
    cart.addItem('garlic', 3);

    // when
    let total = cart.getTotal(products, discounts);

    // then
    expect(total).to.equal(130);
    total /= 100;
    // console.log(total.toLocaleString('en-GB', { style: 'currency', currency: 'GBP', maximumFractionDigits: 2 }));
  });


  it('should get the correct total of items with discounts in the cart', () => {
    // given
    let cart = new Cart();
    cart.addItem('apple', 1);
    cart.addItem('papaya', 6);

    // when
    let total = cart.getTotal(products, discounts);

    // then
    expect(total).to.equal(225);
  });

  it('should get the correct total of items with partial discounts in the cart', () => {
    // given
    let cart = new Cart();
    cart.addItem('apple', 1);
    cart.addItem('papaya', 5);

    // when
    let total = cart.getTotal(products, discounts);

    // then
    expect(total).to.equal(225);
  });

  it('should get the correct total of items with no discounts in the cart', () => {
    // given
    let cart = new Cart();
    cart.addItem('apple', 1);
    cart.addItem('papaya', 2);

    // when
    let total = cart.getTotal(products, discounts);

    // then
    expect(total).to.equal(125);
  });

});
