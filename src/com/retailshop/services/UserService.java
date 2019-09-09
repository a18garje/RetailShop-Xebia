package com.retailshop.services;

import java.util.HashMap;
import java.util.Map;

import com.retailshop.models.Cart;
import com.retailshop.models.Item;
import com.retailshop.models.User;

public class UserService {

  private Map<Long, User> userMap;

  protected UserService() {

    userMap = new HashMap<Long, User>();
  }
  
  protected boolean resisterUser( User user ) {
	  return userMap.put( user.getUserId(), user ) == null ;
  }
  
  protected User removeUser( long userId ) {
	  return userMap.remove( userId );
  }
  
  protected boolean updateUSer( long userId, User user ) {
	  return userMap.put( userId, user ) == null;
  }
  
  protected Map<Long, User> getAllUsers() {
	  return this.userMap;
  }
  
  protected User getUser( long userId ) {
	  return userMap.get( userId );
  }
  
  protected boolean addItemToUserCart( long userId, Item item, int quantity ) {
	  
	  // Step 1: Find user from userId
	  User user = this.getUser( userId );
	  
	  // Step 2: Get Cart of user
	  Cart userCart =  user.getCart();
	  
	  // Step 3: Add Item to cart
	  boolean result = userCart.addToCart( item, quantity );
	  
	  return result;
  }
  
  protected boolean removeItenFromUserCart( long userId, long itemId ) {
	  
	  // Step 1: Find user from userId
	  User user = this.getUser( userId );
	  
	  // Step 2: Get Cart of user
	  Cart userCart =  user.getCart();
	  
	  // Step 3: Remove Item to cart
	  boolean result = userCart.deleteFromCart( itemId );
	  
	  return result;
  } 
  
  protected boolean updateUserCart( long userId, long itemId, int quantity ) {
	  
	  // Step 1: Find user from userId
	  User user = this.getUser( userId );
	  
	  // Step 2: Get Cart of user
	  Cart userCart =  user.getCart();
	  
	  // Step 3: Remove Item to cart
	  boolean result = userCart.updateCart(itemId, quantity);
	  
	  return result;
  }
  
  protected Map<Item, Integer> getAllItemsFromUserCart( long userId ) {
	
	  // Step 1: Find user from userId
	  User user = this.getUser( userId );
		  
	  // Step 2: Get Cart of user
	  Cart userCart =  user.getCart();
	  
	  // Step 3: Get all Items from cart
	  return userCart.getAllItemFromCart();
  }

}
