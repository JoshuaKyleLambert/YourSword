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
public class Maps {
	//TODO replace location with adventure.
	//Locations data = new Locations();
	NodeList data;
	Graph<String> map;

	public Maps(){
		this.data = new NodeList("YourAdventure.txt");
		this.map = new UnweightedGraph<>(data.placeNames, data.paths);
		
	}
		
	public Maps(String filename){
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
	public int travelTo(String destination){
		
	return map.getIndex(destination);
	}
	
	public String look(int location){
		return data.getDescription(location);
	}
        /*Can't list items at other locations
        * or can you?
        */
        
        public void printItems(int location){
            data.getItemList(location).forEach(e -> System.out.println(e));

        }
}

