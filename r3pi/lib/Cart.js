'use strict';

/**
 * A bare-bones implementation of a shopping cart. 
 * 
 * Only adding of items is supported at the moment. Also, all prices are in the lowest denomination possible.
 */
class Cart {

  constructor() {
    this.items = {};
  }

  getItems() {
    return this.items;
  }

  addItem(itemId, qty) {
    if (qty < 1) {
      throw new Error('quantity cannot be less than 1!');
    }

    if (this.items[itemId]) {
      let item = this.items[itemId];
      item.qty += qty;
    } else {
      this.items[itemId] = {
        id: itemId,
        qty: qty
      };
    }
  }

  getDiscountAmount(item, discounts, price) {
    if (item && discounts[item.id] === '3-for-2') {
      let freeItems = parseInt(item.qty / 3);
      return freeItems * price;
    }

    return 0;
  }

  getTotal(products, discounts) {
    let total = 0;

    for (let itemId in this.items) {
      let item = this.items[itemId];
      let price = products[item.id].price;
      let itemSubTotal = price * item.qty;
      let itemDiscount = this.getDiscountAmount(item, discounts, price);

      itemSubTotal -= itemDiscount;
      total += itemSubTotal;
    }

    return total;
  }
  
  getTotalQuantity() {
    let totalQuantity = 0;
    for (let itemId in this.items) {
      let item = this.items[itemId];
      totalQuantity += item.qty;
    }

    return totalQuantity;
  }

}

module.exports = Cart;
