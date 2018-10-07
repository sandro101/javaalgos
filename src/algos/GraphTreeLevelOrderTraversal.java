package algos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class GraphTreeLevelOrderTraversal {
	
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};

	public List<List<Integer>> levelOrder(Node root) {
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	Queue<Node> nodesToVisit = new LinkedList<Node>();
    	if(root == null)
    		return results;
    	nodesToVisit.offer(root);

    	while(!nodesToVisit.isEmpty()) {
    		List<Integer> thisLevel = new ArrayList<Integer>();
    		for (int i = nodesToVisit.size(); i > 0; i--) {
    			Node currentNode = nodesToVisit.poll();
				thisLevel.add(currentNode.val);
	    		for (Node childNode : currentNode.children) {
					nodesToVisit.add(childNode);
				}
			}
    		results.add(thisLevel);   		
    	}    	
        return results;        
    }
	

}