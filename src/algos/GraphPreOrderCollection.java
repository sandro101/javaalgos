package algos;

import java.util.ArrayList;
import java.util.List;

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
}