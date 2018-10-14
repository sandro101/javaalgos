package algos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class GraphCourses {
	
	public static void main(String[] args) {
		int[][] testGrid = new int[][] { {0, 1}, {0, 2}, {1, 2} };
		System.out.println(new GraphCourses().canFinish(2, testGrid));
	}
	
	class GraphNode<T> {
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

    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	Map<Integer, GraphNode<Integer>> nodeMapping = new HashMap<>();
    	if(prerequisites.length == 0) {
    		return true;
    	}
    	if(numCourses == 0 || numCourses == 1) {
    		return true;
    	}
    	for(int[] pair: prerequisites) {
    		GraphNode<Integer> dependsOn;
    		GraphNode<Integer> node;
      		if(nodeMapping.containsKey(pair[0])) {
    			node = nodeMapping.get(pair[0]);
    		} else {
    			node = new GraphNode<Integer>(pair[0]);
    			nodeMapping.put(pair[0], node);
    		} 
    		if(nodeMapping.containsKey(pair[1])) {
    			dependsOn = nodeMapping.get(pair[1]);
    		} else {
    			dependsOn = new GraphNode<Integer>(pair[1]);
    		}    		
    		dependsOn.addAdjacent(node);  
    		nodeMapping.put(pair[1], dependsOn);
    	}
    	Iterator<GraphNode<Integer>> iter = nodeMapping.values().iterator();
    	while(iter.hasNext()) {
    		if(bfs(iter.next()) >= numCourses) {
    			return true;
    		}
    	}
    	return false;        
    }

	private int bfs(GraphNode<Integer> node) {
    	Set<Integer> visited = new HashSet<>();
    	Queue<GraphNode<Integer>> nodes = new LinkedList<>();
    	nodes.add(node);
    	int count = 0;
    	while(!nodes.isEmpty()) {
      		GraphNode<Integer> currentNode = nodes.poll();
    		if(visited.contains(currentNode.data)) {
    			count--;
    			return count;
    		}
      		count++;
    		Iterator<GraphNode<Integer>> iter = currentNode.adjacents.iterator();
    		while(iter.hasNext()) {
    			nodes.add(iter.next());
    		}    		
    		visited.add(currentNode.data);
    	}
    	return count;		
	}

}