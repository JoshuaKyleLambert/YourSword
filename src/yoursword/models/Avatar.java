/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoursword.models;

import java.util.ArrayList;

/**
 *
 * @author joshua
 */
public class Avatar {

	private String name;
	private int health = 100;
	private int armor = 100;
	private int magic = 100;
	ArrayList<Item> inventory = new ArrayList<>();
	UnweightedGraph<Locations> map = new UnweightedGraph<>();
	int currentLocation = 0;  // Location is the index # in the graph.

	public Avatar(String name) {
		inventory.add(new Item("Water", 5, "Cool and refreshing"));
		this.setName(name);
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

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}

	public UnweightedGraph<Locations> getMap() {
		return map;
	}

	public void setMap(UnweightedGraph<Locations> map) {
		this.map = map;
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

	public void listInventory(){
		System.out.println("You have: ");
		getInventory().forEach((e) -> System.out.println(e.getQuantity() + " " + e.getName() +" "+ e.getDescription()));
	}
}
