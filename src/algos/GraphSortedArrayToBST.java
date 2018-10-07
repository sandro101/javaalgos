package algos;

class GraphSortedArrayToBST {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		int[] testIntArry = new int[] { -10,-3,0,5,9 };
		new GraphSortedArrayToBST().sortedArrayToBST(testIntArry);
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		TreeNode root = buildTree(0, nums.length - 1, nums);
		return root;
	}
	
	private TreeNode buildTree(int l, int r, int[] nums) {
		if (l > r) {
			return null;
		}
		int m = (l + r) / 2;
		TreeNode parent = new TreeNode(nums[m]);
		parent.left = buildTree(l, m - 1, nums);
		parent.right = buildTree(m + 1, r, nums);
		return parent;
	}
}