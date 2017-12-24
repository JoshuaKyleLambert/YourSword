/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoursword.models;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

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

//		System.out.println("The number of vertices in graph1: " + map.getSize());
//
//		System.out.println("The vertex with index 1 is "
//			+ map.getVertex(1));
//		System.out.println("The index for Miami is "
//			+ map.getIndex("Miami"));
//		System.out.println("The edges for graph1:");
//		map.printEdges();
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
     * @return the item taken. null if doesnt exist?
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
     * @param Location world location to drop to
     * @param itemName item to drop
     */
    public void drop(int Location, String itemName) {

    }

    public String look(int location) {
        return data.getDescription(location);
    }

    /**
     * print the list of items contained at the location.
     * @param location 
     */
    public void printItems(int location) {
        data.getNodeInventory(location).toString();
    }
}
