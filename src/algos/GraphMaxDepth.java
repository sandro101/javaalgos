package algos;

import java.util.List;

class GraphMaxDepth {

	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};

    public int maxDepth(Node root) {
        if(root == null) return 0;
    	int maxDepth = 0;
    	for (Node n : root.children) {
    		maxDepth = Math.max(maxDepth(n), maxDepth); 
		}		
		return maxDepth + 1;		
    }

}