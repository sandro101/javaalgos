package algos;

import java.util.Stack;

public class TreeRangeSumBst {
	
	// https://leetcode.com/problems/range-sum-of-bst/discuss/194047/Medium-I-don't-think-so

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

    public int rangeSumBST(TreeNode root, int l, int r) {
    	Stack<TreeNode> s = new Stack<>();
    	s.add(root);
    	int sum = 0;
    	while(!s.isEmpty()) {
    		TreeNode n = s.pop();
    		if(n != null) {
        		if(n.val >= l && n.val <= r) {
        			sum += n.val;
        		}
        		if(n.val > l) s.add(n.left);
        		if(n.val < r) s.add(n.right); 
    		}  		
    	}
        return sum;
    }
};