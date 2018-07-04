package establishedalgos.datastructures;

import java.util.LinkedList;

public class GraphNode<T> {
	public LinkedList<GraphNode<T>> adjacents;
	public T data;
	
	public GraphNode(T data){
		this.data = data;
		this.adjacents = new LinkedList<GraphNode<T>>();
	}
	
	public void addAdjacent(GraphNode<T> adjacent) {
		this.adjacents.add(adjacent);
	}
}
