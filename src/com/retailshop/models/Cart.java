package com.retailshop.models;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cart {

  private Map<Item, Integer> itemsInCart;

  protected Cart() {

    itemsInCart = new HashMap<Item, Integer>();
  }

  public boolean addToCart( Item item, int quantity ) {

    return itemsInCart.put(item, quantity) == null;
  }

  public boolean updateCart( long itemId, int quantity ) {

    Iterator<Map.Entry<Item, Integer>> cartItemIterator = this.itemsInCart.entrySet().iterator();

    while( cartItemIterator.hasNext() ) {

      Map.Entry<Item, Integer> entry = cartItemIterator.next();

      if( entry.getKey().getItemId() == itemId ) {

        entry.setValue(quantity);
        return true;
      }
    }

    return false;

  }

  public boolean deleteFromCart( long itemId ) {

    Iterator<Map.Entry<Item, Integer>> cartItemIterator = this.itemsInCart.entrySet().iterator();

    while( cartItemIterator.hasNext() ) {

      Map.Entry<Item, Integer> entry = cartItemIterator.next();

      if( entry.getKey().getItemId() == itemId ) {

        this.itemsInCart.remove( entry.getKey() );
        return true;
      }
    }

    return false;
  }

  public Map<Item, Integer> getAllItemFromCart() {
    return this.itemsInCart;
  }
  
  public boolean isEmpty() {
	  
	  return itemsInCart.size() == 0;
  }

}
