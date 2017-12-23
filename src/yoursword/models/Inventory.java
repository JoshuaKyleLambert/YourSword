/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoursword.models;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author joshua
 */
public class Inventory {

	private Map<String, Item> LinkedHashMap;

	public Inventory() {
		//Create a empty inventory with room for 8 grows to 16 
		//with 6 items because of .75 load factor.
		LinkedHashMap = new LinkedHashMap<>(8, .75f);
		//items = new LinkedHashMap<>();

	}

	public Inventory(Item item) {
		//Create an inventory with 1 item room for 7 grows to 16 
		//with 6 items because of .75 load factor.
		LinkedHashMap = new LinkedHashMap<>(8, 0.75f);
		LinkedHashMap.put(item.getName(), item);

	}

	/**
	 *
	 * @param item
	 *
	 */
	public void put(Item item) {
		if (LinkedHashMap.containsKey(item.getName())) {
			Item inventoryItem = LinkedHashMap.get(item.getName());
			int qty = inventoryItem.getQuantity();

			inventoryItem.setQuantity(qty + item.getQuantity());

		} else {
			put(item);
		}

		System.out.println(item.getQuantity() + " " + item.getName() + " added to inventory.");
	}

	public void remove(Item item) {
		if (LinkedHashMap.containsKey(item.getName())) {
			Item inventoryItem = LinkedHashMap.get(item.getName());
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
}
