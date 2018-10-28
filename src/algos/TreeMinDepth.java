package algos;

public class TreeMinDepth {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

    public int minDepth(TreeNode root) {
        int height = 0;
        return findMinDepth(root, height);
    }

	private int findMinDepth(TreeNode n, int h) {
		// Question here defined a leaf as being a node with no children,
		// so a series of steps to the first null is not good enough, if
		// that was the question the Math.min(findMinDepth(n.left, h + 1), findMinDepth(n.right, h + 1));
		// approach would have sufficed.
		if(n == null) return h;
		if(n.left != null && n.right != null) {
			h = Math.min(findMinDepth(n.left, h + 1), findMinDepth(n.right, h + 1));
		} else {
        	if(n.left == null) {
        		h = findMinDepth(n.right, h + 1);
        	} else {
        		h = findMinDepth(n.left, h + 1);
        	}
        }
		return h;
	}
};