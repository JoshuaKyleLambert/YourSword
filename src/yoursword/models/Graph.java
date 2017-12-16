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
public interface Graph<V> {

	public int getSize();

	public java.util.List<V> getVertices();

	public V getVertex(int index);

	public int getIndex(V v);

	public java.util.List<Integer> getNeighbors(int index);

	public int getDegree(int v);

	public void printEdges();

	public void clear();

	public boolean addVertex(V vertex);

	public boolean addEdge(int u, int v);

	public AbstractGraph<V>.Tree dfs(int v);

	public AbstractGraph<V>.Tree bfs(int v);

}
