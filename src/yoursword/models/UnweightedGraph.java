/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yoursword.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joshua
 */
public class UnweightedGraph<V> extends AbstractGraph<V> {

	public UnweightedGraph() {

	}

	/**
	 * Construct a graph from vertices and edges stored in arrays
	 */
	public UnweightedGraph(V[] vertices, int[][] edges) {
		super(vertices, edges);
	}

	public UnweightedGraph(List<V> vertices, List<Edge> edges) {
		super(vertices, edges);
	}

	//public boolean addLocation(Locations loc) {
	//	return addLocationEdges((V) loc, loc.edges);
	//}
	public boolean addLocationEdges(V location, ArrayList<Edge> edges) {
		boolean test = false;
		super.addVertex(location);

		for (int i = 0; i < edges.size(); i++) {
			test = super.addEdge(edges.get(i));
		}
		return test;
	}

}
