/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoursword.models;

/**
 *
 * @author joshua
 */
public class World {
    //TODO replace location with adventure.
    //Locations data = new Locations();

    NodeList data;
    Graph<String> map;

    public World() {
        this.data = new NodeList("YourAdventure.txt");
        this.map = new UnweightedGraph<>(data.placeNames, data.paths);

    }

    public World(String filename) {
        this.data = new NodeList(filename);
        this.map = new UnweightedGraph<>(data.placeNames, data.paths);

    }

    public void printCurrentLocation(int index) {

        System.out.println("\nYour current Location is " + data.getPlaceName(index));
        System.out.println("\nAvailable destinations incude: \n");
        map.getNeighbors(index).forEach((i) -> {
            System.out.print(data.getPlaceName(i) + "  ");
        });

        System.out.println("\n");

    }

    /**
     *
     * @param destination
     * @return
     */
    public int travelTo(String destination) {

        return map.getIndex(destination);
    }

    /**
     * Take an item from the world location
     *
     * @param Location world location to take from
     * @param itemName item you wish to take from location
     * @return the item taken. null if doesn't exist.
     *
     */
    public Item take(int Location, String itemName) {
        Item item = data.getNodeInventory(Location).get(itemName);
        data.getNodeInventory(Location).remove(item);

        return item;
    }

    /**
     *
     * Drop an item onto the world location
     *
     * @param location
     * @param itemName item to drop
     */
    public void leave(int location, Item item) {
       // Item item = data.getNodeInventory(location).get(itemName);
        data.getNodeInventory(location).put(item);
    }

    public String look(int location) {
        return data.getDescription(location);
    }

    /**
     * print the list of items contained at the location.
     *
     * @param location
     */
    public void printItems(int location) {
        data.getNodeInventory(location).toString();
    }
}
