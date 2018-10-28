package algos;

import java.util.ArrayList;
import java.util.List;

class TreePruneBST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode trimBSTRecreateTree(TreeNode root, int l, int r) {
		List<Integer> vals = new ArrayList<>();
		walk(root, vals, l, r);
		TreeNode t = buildBST(vals, 0, vals.size() - 1);
		return t;
	}

	private TreeNode buildBST(List<Integer> vals, int l, int r) {
		if(l > r) return null;
		int m = (l + r)/2;
		TreeNode p = new TreeNode(vals.get(m));
		p.left = buildBST(vals, l, m - 1);
		p.right = buildBST(vals, m + 1, r);
		return p;
	}

	private void walk(TreeNode root, List<Integer> vals, int l, int r) {
		if(root != null) {
			walk(root.left, vals, l, r);
			if(root.val >= l && root.val <= r) {
				vals.add(root.val);
			}
			walk(root.right, vals, l, r);
		}		
	}
	
    public TreeNode trimBST(TreeNode node, int L, int R) {
    	if(node == null) return null;
    	//if the node is less than min or greater than max skip this node, 
    	//i.e do not return node and instead move right/left and return the outcome of that
    	if(node.val < L) return trimBST(node.right, L, R);
    	if(node.val > R) return trimBST(node.left, L, R);
    	
    	//if the node is within the range of min and max we are going to want to
    	//keep it (i.e return it) and explore left and right to see if there is 
    	//more fitting into the range
    	node.left = trimBST(node.left, L, R);
    	node.right = trimBST(node.right, L, R);
    	return node;
    }
	
}