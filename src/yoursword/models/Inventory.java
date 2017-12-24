/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoursword.models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import yoursword.items.FilthySock;
import yoursword.items.Water;

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
     * Add and Item instance to the inventory
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
            invList.put(item.getName(), item);
        }

        System.out.println(item.getQuantity() + " " + item.getName() + " added to inventory.");
    }

    /**
     * Remove and Item instance from inventory
     *
     * @param item
     */
    public void remove(Item item) {
        if (invList.containsKey(item.getName())) {
            Item inventoryItem = invList.get(item.getName());
            int qty = inventoryItem.getQuantity();

            invList.remove(item.getName());

//            if (qty - item.getQuantity() <= 0) {
//                
//            } else {
//                inventoryItem.setQuantity(qty - item.getQuantity());
//            }
        } else {
            System.out.println("That cannot be removed. It is not in inventory.");
        }

    }

    public Item get(String itemName) {
        return invList.get(itemName);
    }

    public Set getentrySet() {
        return invList.entrySet();
    }

    public ArrayList<Item> getItems() {
        return (ArrayList) invList.values();
    }

    /**
     * Creates instances of names items and adds them to inventory.
     *
     * @param items
     * @return
     */
    public boolean addStringArray(String[] items) {
        // ArrayList<Item> itemList = new ArrayList<>();
        for (String each : items) {
            switch (each) {
                case "Water":
                    put(new Water(1));
                    break;
                case "FilthySock":
                    put(new FilthySock(1));
                    break;
                default:
                    return false;

            }
        }

        return true;
    }

    @Override
    public String toString() {
        Set<Map.Entry<String, Item>> entrySet = invList.entrySet();
        StringBuilder string = new StringBuilder();
        StringBuilder returnstring = new StringBuilder();
      
        // Get key and value from each entry
        for (Map.Entry<String, Item> entry : entrySet) {
            string.append(entry.getValue().getQuantity()).append("  ")
                    .append(entry.getValue().getDescription()).append(" ")
                    .append(entry.getKey());
            System.out.println(string.toString());

            returnstring.append(string).append("\n");
            string.delete(0, string.length());

        }

        return returnstring.toString();
    }
}
