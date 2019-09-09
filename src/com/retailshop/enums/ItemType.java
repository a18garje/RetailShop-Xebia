package com.retailshop.enums;

public enum ItemType {
	
	GROCERY( "grocery" ),
	NONGROCERY( "nongrocery" );
	
	private String value;
	
	private ItemType( String type ) {
		this.value = type;
	}
	
	public String getValue() {
		return this.value;
	}
}
