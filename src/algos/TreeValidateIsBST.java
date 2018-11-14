package algos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TreeValidateIsBST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isValidBST(TreeNode root) {
		List<Integer> l = new ArrayList<Integer>();		
		Set<Integer> s = new HashSet<Integer>();		
		dfs(root, l, s);
		if(s.size() < l.size()) return false;
		List<Integer> lc = new ArrayList<>(l);
        System.out.println(l);
		l.sort(Comparator.naturalOrder());        
		return l.equals(lc);		
	}

	private void dfs(TreeNode root, List<Integer> l, Set<Integer> s) {
		if(root == null) return;
        dfs(root.left, l, s);
		l.add(root.val); 
		s.add(root.val);
        dfs(root.right, l, s);
	}

};