package algos;

public class TreeMaxDepth {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

    public int maxDepth(TreeNode root) {
        int height = 0;
        return findMaxDepth(root, height);
    }

	private int findMaxDepth(TreeNode n, int h) {
		if(n == null) return h;
		h = Math.max(findMaxDepth(n.left, h + 1), findMaxDepth(n.right, h + 1));
		return h;
	}
};