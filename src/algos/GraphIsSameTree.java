package algos;

import java.util.ArrayList;
import java.util.List;

class GraphIsSameTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p != q && (p == null || q == null)) return false;
		List<Integer> nodesFromP = dfs(p);
		List<Integer> nodesFromQ = dfs(q);
		return (nodesFromP.equals(nodesFromQ));
	}

	private List<Integer> dfs(TreeNode n) {
		List<Integer> nodes = new ArrayList<Integer>();
		if(n.left != null) {
			nodes.addAll(dfs(n.left)) ;
		}
		else { 
			nodes.add(-1);
		}
		nodes.add(n.val);
		if(n.right != null) {
			nodes.addAll(dfs(n.right)) ;
		}
		else { 
			nodes.add(-1);
		}
		return nodes;
	}

}