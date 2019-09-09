import java.util.List;

import com.retailshop.enums.ItemType;
import com.retailshop.models.Item;
import com.retailshop.services.RetailShop;

public class Executor {

	public static void main( String []args ) {

		RetailShop retailShop = new RetailShop();
		Item item;
		ItemType itemType;

	 	itemType = ItemType.NONGROCERY;
		item = new Item( 1001, "ABC", "Sweet and tasty", itemType, 200);
		retailShop.addItemToInventory(item, 5);

		itemType = ItemType.GROCERY;
		item = new Item( 1002, "PQR", "Spicy and tasty", itemType, 300);
		retailShop.addItemToInventory(item, 5);

		retailShop.showAllItems();
		retailShop.updateQuantityOfItem(1002, 7);
		item = new Item( 1002, "PQR", "Spicy and tasty", itemType, 400);
		retailShop.updateItemFromInventory(1002, item);
		retailShop.showAllItems();

	}
}
