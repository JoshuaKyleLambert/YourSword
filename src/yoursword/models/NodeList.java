/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoursword.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
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

	public NodeList(String filename) {
		nodes = new ArrayList<>();
		
		//int[][] paths;
		nodes = loadNodes(filename);
		numberOfnodes = nodes.size();
		descriptions = new String[numberOfnodes];
		
		
		placeNames = new String[nodes.size()];
		for (int i = 0; i < nodes.size(); i++) {
			placeNames[i] = nodes.get(i).getName();
		}
		paths  = paths();
		for(int i = 0; i < nodes.size(); i++){
			descriptions[i] = nodes.get(i).getDescription();
		}
			
	}

	public String[] placeNames() {
		//list of all node names
		return placeNames;

	}

	public int[][] paths() {
		//list of all the edges using indexes instead of names	
		//ArrayList<String> tempEdges = new ArrayList<>();
		int[][] temppaths = new int[numberOfnodes][2];

		for (int i = 0; i < numberOfnodes; i++) {
			ArrayList<String> tempEdges = new ArrayList<>();
			tempEdges.addAll(nodes.get(i).getEdges());

			for (int j = 0; j < tempEdges.size(); j++) {
				temppaths[i][0] = i;
				temppaths[i][j] = nodes.indexOf(tempEdges.get(j));
			}

		}

		return temppaths;
	}

	public String getDescription(int index) {

		return nodes.get(index).getDescription();

	}

	public String getPlaceName(int index) {

		return nodes.get(index).getName();
	}

	private ArrayList<Node> loadNodes(String filename) {
		ArrayList<Node> newNodesList = new ArrayList<>();

		Node newNode = new Node();

		try {
			BufferedReader input = new BufferedReader(new FileReader("YourAdventure.ysa"));

			String[] edges;
			
			String fileRead = input.readLine();
			while (fileRead != null) {
			StringBuilder description = new StringBuilder();
				tokens = fileRead.split(",");

				edges = Arrays.copyOfRange(tokens, 1, tokens.length - 1); // edge list
//				for (int i = 1; i < tokens.length; i++) {
//
//					newNode.addEdge(tokens[i]);
//				}
				fileRead = input.readLine();

				while (!fileRead.equals("###")) {
					description.append(fileRead);
					fileRead = input.readLine();

				}
				newNode = new Node(tokens[0], edges, description.toString());  // node name
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

//		temp = "LOCATIONS";
//
//		while (input.hasNext()) {
//			int count = 0;
//
//			switch (temp) {
//
//				case "LOCATIONS":
//					count = 0;
//
//					while (!temp.equals("PATHS")) {
//						count++;
//						places.add(temp = input.next());
//					}
//					System.out.println(places.toString());
//					break;
//				case "PATHS":
//					getLine = new Scanner(input.nextLine());
//					while (!temp.equals("DESCRIPTIONS")) {
//
//						new Scanner(input.next());
//
//					}
//				//while
//				//break;
//				case "DESCRIPTIONS":
//					break;
//				default:
//
//					break;

