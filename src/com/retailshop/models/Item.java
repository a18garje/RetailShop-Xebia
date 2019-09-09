package com.retailshop.models;

import com.retailshop.enums.ItemType;

public class Item {

	private long itemId;
	private String name;
	private String description;
	private ItemType itemType;
	private double price;

	public Item(long itemId, String name, String description, ItemType itemType, double price) {
		this.itemId = itemId;
		this.name = name;
		this.description = description;
		this.itemType = itemType;
		this.price = price;
	}

	public ItemType getItemType() {
		return itemType;
	}
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	@Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    result = prime * result + (int) (itemId ^ (itemId >>> 32));
    result = prime * result + ((itemType == null) ? 0 : itemType.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    long temp;
    temp = Double.doubleToLongBits(price);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Item other = (Item) obj;
    if (description == null) {
      if (other.description != null)
        return false;
    } else if (!description.equals(other.description))
      return false;
    if (itemId != other.itemId)
      return false;
    if (itemType != other.itemType)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
      return false;
    return true;
  }

  @Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", price=" + price + ", description=" + description + ", itemType=" + itemType
				+ "]";
	}

}
