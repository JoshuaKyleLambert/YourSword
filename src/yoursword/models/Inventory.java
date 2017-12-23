/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoursword.models;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author joshua
 */
public class Inventory {

	private Map<String, Item> invList;

	public Inventory() {
		//Create a empty inventory with room for 8 grows to 16 
		//with 6 items because of .75 load factor.
		invList = new LinkedHashMap<>(8, .75f);
		//items = new invList<>();

	}

	public Inventory(Item item) {
		//Create an inventory with 1 item room for 7 grows to 16 
		//with 6 items because of .75 load factor.
		invList = new LinkedHashMap<>(8, 0.75f);
		invList.put(item.getName(), item);

	}

	/**
	 *
	 * @param item
	 *
	 */
	public void put(Item item) {
		if (invList.containsKey(item.getName())) {
			Item inventoryItem = invList.get(item.getName());
			int qty = inventoryItem.getQuantity();

			inventoryItem.setQuantity(qty + item.getQuantity());

		} else {
			invList.put(item.getName(),item);
		}

		System.out.println(item.getQuantity() + " " + item.getName() + " added to inventory.");
	}

	public void remove(Item item) {
		if (invList.containsKey(item.getName())) {
			Item inventoryItem = invList.get(item.getName());
			int qty = inventoryItem.getQuantity();

			if (qty - item.getQuantity() <= 0) {
				remove(item);
			} else {
				inventoryItem.setQuantity(qty - item.getQuantity());
			}

		} else {
			System.out.println("That cannot be removed. It is not in inventory.");
		}

	}
	
	public Item get(String itemName){
		return invList.get(itemName);
	}

	public Set getentrySet() {
		return invList.entrySet();
	}
	

	
	
}
