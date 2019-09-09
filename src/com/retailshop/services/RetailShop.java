package com.retailshop.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.retailshop.models.Cart;
import com.retailshop.models.Item;
import com.retailshop.models.User;

public class RetailShop {
	
	private Inventory inventory;
	private UserService userService;
	
	public RetailShop() {
		// TODO Auto-generated constructor stub
		
		inventory = new Inventory();
		userService = new UserService();
	}
	
	public void addItemToInventory( Item item, int quantity ) {
		inventory.addItem( item, quantity );
	}
	
	public void removeItemFromInventory( long itemId ) throws Exception {
		inventory.removeItem( itemId );
	}
	
	public boolean updateQuantityOfItem( long itemId, int quantity ) {
		return inventory.updateItemQuantity(itemId, quantity);
	}
	
	public boolean updateItemFromInventory( long itemId, Item item ) {
		return inventory.updateItem( itemId, item );
	}
	
	public List<Item> getAllItems() { 
		
		List<Item> itemList = new ArrayList<Item>( inventory.getAllItems() );
		
		return itemList;
	}
	
	public void showAllItems() {
		List<Item> itemList = this.getAllItems();
		
		for( Item item : itemList ) {
			System.out.println( item );
		}
	}
	
	
	public boolean addItemToCart( long userId, long itemId, int quantityToCart ) throws Exception {
		
		boolean isItemAddedToCart;
		boolean isInventoryUpdated;
		int quantityRemain;
		// Step 1: Check item is available in inventory
		int quantityInInventory = inventory.getQuantityOfItemFromInventory( itemId );
		
		if( quantityInInventory >= quantityToCart ) {
			Item item = inventory.getItemFromInventory( itemId );
			
			isItemAddedToCart = userService.addItemToUserCart( userId, item, quantityToCart );
			
			if( isItemAddedToCart ) {
				
				quantityInInventory = quantityInInventory - quantityToCart;
				isInventoryUpdated = inventory.updateItemQuantity( itemId, quantityInInventory );
				
				if( isInventoryUpdated ) {
					return true;
				} else {
					
					String errMsg = "Exception occured while updating inventory for ItemId [" + itemId + "]";
					throw new Exception( errMsg );
				}
			} else {
				
				String errMsg = "Exception occurer while adding Item [" + itemId + "] to cart";
				throw new Exception( errMsg );
			}
			
		} else {
			
			String errMsg = "Exception occured, quantity [" + quantityToCart + "] is not available for Item [" + itemId + "] in inventory";
			throw new Exception( errMsg );
		}
		
	}
	
	public boolean updateItemFromCart( long userId, long itemId, int quantity ) {
		
		return userService.updateUserCart( userId, itemId, quantity );
	}
	
	public boolean removeItemFromCart( long userId, long itemId ) {
		
		// Step 1: Find user by userId
		User user = userService.getUser( userId );
		
		// Step 2: Get cart of user
		Cart cart = user.getCart();
		
		// Step 3: Remove Item from cart
		return cart.deleteFromCart( itemId );
		
	} 
	
	public Map<Item, Integer> showUserCart( long userId ) {
		
		User user = userService.getUser( userId );
		Cart cart = user.getCart();
		
		return cart.getAllItemFromCart();
	}
	
}
