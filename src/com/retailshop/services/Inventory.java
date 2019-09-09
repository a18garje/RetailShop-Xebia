package com.retailshop.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.retailshop.models.Item;

public class Inventory {
	
	private Map<Long, Integer> itemQuantity;
	private Map<Long, Item> itemMap; 
	
	protected Inventory() {
		itemMap = new HashMap<Long, Item>();
		itemQuantity = new HashMap<Long, Integer>();
	}
	
	public void addItem( Item item, int quantity ) {
		itemQuantity.put( item.getItemId(), quantity );
		itemMap.put( item.getItemId(), item );
	}
	
	public void removeItem( long itemId ) throws Exception {
		
		if( itemQuantity.containsKey( itemId ) ) {
			itemQuantity.remove( itemId );
			itemMap.remove( itemId );
		} else {
			String errorMsg = "Item with itemId [" + itemId + "] not found" ;
			throw new Exception( errorMsg );
		}
		
	}
	
	public boolean updateItemQuantity( long itemId, int quantity ) {
		return itemQuantity.put( itemId, quantity ) == null;
	}
	
	public boolean updateItem( long itemId, Item item ) {
		return itemMap.put( itemId, item ) == null;
	}
	
	public Collection<Item> getAllItems() {
		return itemMap.values();
	}
	
	public int getQuantityOfItemFromInventory( long itemId ) {
		return itemQuantity.get( itemId );
	}
	
	public Item getItemFromInventory( long itemId ) {
		return itemMap.get( itemId );
	}
}
