/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoursword.models;

import java.util.Map;
import java.util.Set;
import yoursword.items.Water;

/**
 *
 * @author joshua
 */
public class Avatar {

    private String name;
    private int health = 100;
    private int armor = 100;
    private int magic = 100;
    Inventory inventory = new Inventory();
    int currentLocation = 0;  // Location is the index # in the graph.

    public Avatar(String name) {

        Item item = new Water(5);

        inventory.put(item); // give 5 water to start.
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(int currentLocation) {
        this.currentLocation = currentLocation;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * prints the players inventory to console.
     * 
     */
    public void listInventory() {
        System.out.println("You have: ");
        Set<Map.Entry<String, Item>> list = inventory.getentrySet();

        for (Map.Entry<String, Item> entry : list) {
            System.out.println(entry.getValue()); // calls the item toString method
        }

    }

    public void give(Item item) {
        //inventory.put(item.getName(), item);

    }
}
