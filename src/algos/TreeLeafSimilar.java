package algos;

import java.util.ArrayList;
import java.util.List;

public class TreeLeafSimilar {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return dfs(root1, new ArrayList<Integer>()).equals(dfs(root2, new ArrayList<Integer>()));
    }

	private List<Integer> dfs(TreeNode node, List<Integer> l) {
		if(node.left == null && node.right == null) {
			l.add(node.val);
			return l;
		}
		dfs(node.left, l);
		dfs(node.right, l);		
		return l;
	}
};