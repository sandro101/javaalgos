package algos;

class TreeBSTKthSmallest {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int kthSmallest(TreeNode root, int k) {
		int count = this.countNodes(root.left); // how many nodes are smaller than this one
		if(count + 1 == k) return root.val;
		if(k <= count) { 
			// if there are more than k numbers smaller than current node go left to a smaller node
			return kthSmallest(root.left, k);
		} else {
			// if there are not enough numbers on the left smaller than this one to make it up to k
			// we are going to have to head down the right hand side
			return kthSmallest(root.right, k - count - 1);
		}
	}
	
	private int countNodes(TreeNode root){
		if(root == null) {
			return 0;
		}
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
}