/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoursword.models;

import java.util.ArrayList;
import java.util.Arrays;
import yoursword.items.*;

/**
 *
 * @author joshua
 */
public class Node {

    ArrayList<Item> items = new ArrayList<>();

    private String name;
    private ArrayList<String> edges;
    private int edgecount;
    private String description;

    public Node() {
        this.name = "";
        this.edges = new ArrayList();
        this.description = "";
        this.edgecount = 0;
    }

    public Node(String name) {
        this.name = name;
        this.edges = new ArrayList();
        this.description = "";
        this.edgecount = 0;
    }

    public Node(String name, String[] edges, String description) {
        this.name = name;
        this.edges = new ArrayList(Arrays.asList(edges));
        this.description = description;
        edgecount = edges.length;

    }

    public Node(String name, String[] edges, String description, String[] item) {
        this.name = name;
        this.edges = new ArrayList(Arrays.asList(edges));
        this.description = description;
        edgecount = edges.length;
        this.items.addAll(parseItemList(item));

    }

    public void addEdge(String name) {
        edges.add(name);
        edgecount++;
    }

    public ArrayList<String> getEdges() {
        return edges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdgecount() {
        return edgecount;
    }

    public void setEdgecount(int edgecount) {
        this.edgecount = edgecount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Item> itemList() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        if (items.indexOf(item) == -1) {
            System.out.println("That's not here");
        }
    }

    private ArrayList<Item> parseItemList(String[] items) {
        ArrayList<Item> itemList = new ArrayList<>();
        for (String each : items) {
            switch (each) {
                case "Water":
                    itemList.add(new Water(1));
                    break;
                case "FilthySock":
                    itemList.add(new FilthySock(1));
                    break;

            }
        }

        return itemList;
    }

}
