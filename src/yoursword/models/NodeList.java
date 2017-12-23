/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoursword.models;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joshua
 */
public class NodeList {

	String[] tokens;
	//StringBuilder description = new StringBuilder();
	//BufferedReader input;
	ArrayList<Node> nodes;
	String[] placeNames;
	String[] descriptions;
	int[][] paths;
	int numberOfnodes;
	int numberOfpaths;

	public NodeList(String filename) {
		nodes = new ArrayList<>();

		//int[][] paths;
		nodes = loadNodes(filename);
		numberOfnodes = nodes.size();
		descriptions = new String[numberOfnodes];

		this.placeNames = new String[nodes.size()];
		for (int i = 0; i < nodes.size(); i++) {
			this.placeNames[i] = nodes.get(i).getName();
		}
		paths = paths();
		for (int i = 0; i < nodes.size(); i++) {
			this.descriptions[i] = nodes.get(i).getDescription();
		}

	}

	public String[] placeNames() {
		//list of all node names
		return placeNames;

	}

	public int[][] paths() {
		//list of all the edges using indexes instead of names
		//ArrayList<String> tempEdges = new ArrayList<>();

		ArrayList<String> tempEdges = new ArrayList<>();
		ArrayList<Integer> edgeCount = new ArrayList<>();
		for (int i = 0; i < numberOfnodes; i++) {
			edgeCount.add(nodes.get(i).getEdgecount());
			tempEdges.addAll(nodes.get(i).getEdges());

		}

		this.numberOfpaths = tempEdges.size();
		int[][] temppaths = new int[tempEdges.size()][2];
		int counter = 0;
		for (int i = 0; i < numberOfpaths && counter < edgeCount.size(); i += edgeCount.get(counter++)) {
			for (int j = 0; j < edgeCount.get(counter); j++) {

				temppaths[i + j][0] = counter;
				temppaths[i + j][1] = Arrays.asList(placeNames).indexOf(tempEdges.get(i + j));

			}

		}

		return temppaths;
	}
        
        public ArrayList<Item> getItemList(int index){
            return nodes.get(index).itemList();
        }

	public String getDescription(int index) {

		return nodes.get(index).getDescription();

	}

	public String getPlaceName(int index) {

		return nodes.get(index).getName();
	}

	private ArrayList<Node> loadNodes(String filename) {
		ArrayList<Node> newNodesList = new ArrayList<>();

		//Node newNode = new Node();

		try {
			BufferedReader input = new BufferedReader(new FileReader(filename));

			String[] edges;
                        String[] items;
			String fileRead = input.readLine();
			while (fileRead != null) {
				StringBuilder description = new StringBuilder();
				tokens = fileRead.split(",");
                                items = fileRead.split(",");
                                
				edges = Arrays.copyOfRange(tokens, 1, tokens.length); // edge list

				fileRead = input.readLine();

				while (!fileRead.equals("###")) {
					description.append(fileRead).append("\n");
					fileRead = input.readLine();

				}
				Node newNode = new Node(tokens[0], edges, description.toString(),items);  // node name
				
                                fileRead = input.readLine();
				newNodesList.add(newNode);

			}

		} catch (FileNotFoundException ex) {
			Logger.getLogger(NodeList.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(NodeList.class.getName()).log(Level.SEVERE, null, ex);
		}
		return newNodesList;
	}

}
