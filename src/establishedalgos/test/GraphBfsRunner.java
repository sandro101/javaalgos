package establishedalgos.test;

import establishedalgos.Algos;
import establishedalgos.datastructures.GraphNode;

public class GraphBfsRunner {
	
	public static void main(String args[]) {
		GraphNode<Integer> one = new GraphNode<Integer>(1);
		GraphNode<Integer> two = new GraphNode<Integer>(2);
		GraphNode<Integer> three = new GraphNode<Integer>(3);
		GraphNode<Integer> four = new GraphNode<Integer>(4);
		GraphNode<Integer> five = new GraphNode<Integer>(5);
		GraphNode<Integer> six = new GraphNode<Integer>(6);
		GraphNode<Integer> seven = new GraphNode<Integer>(7);
		GraphNode<Integer> eight = new GraphNode<Integer>(8);
		GraphNode<Integer> nine = new GraphNode<Integer>(9);
		GraphNode<Integer> ten = new GraphNode<Integer>(10);
		GraphNode<Integer> eleven = new GraphNode<Integer>(11);
		
		eight.addAdjacent(nine);
		eight.addAdjacent(ten);
		eight.addAdjacent(eleven);
		
		six.addAdjacent(seven);
		
		five.addAdjacent(six);
		five.addAdjacent(eight);
		
		two.addAdjacent(seven);
		two.addAdjacent(ten);
		
		one.addAdjacent(two);
		one.addAdjacent(three);
		one.addAdjacent(four);
		one.addAdjacent(five);
		
		Algos.bfsOfGraph(one);
	}
}
