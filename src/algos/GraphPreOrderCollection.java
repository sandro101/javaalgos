package algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class GraphPreOrderCollection {

	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};

    public List<Integer> preorder(Node root) {
    	List<Integer> nodes = new ArrayList<Integer>();
    	if(root == null) return nodes;
    	nodes.add(root.val);
    	for (Node node : root.children) {
			nodes.addAll(preorder(node));
		}
    	return nodes;        
    }
    
    public List<Integer> preorderIter(Node root) {    	
    	List<Integer> nodes = new ArrayList<Integer>();
    	if(root == null) return nodes;
    	Stack<Node> s = new Stack<>();
    	s.push(root);
    	
    	while(!s.isEmpty()) {
    		Node n = s.pop();
    		nodes.add(n.val);
    		List<Node> c = n.children;
    		Collections.reverse(c);
    		s.addAll(c);
    	}
    	
    	return nodes;
    }
}