package algos;

public class BalancedTree {
	
	public static boolean isTreeBalanced(TreeNode treeNode){		
		int left = checkBalanced(treeNode.left, 0);
		int right = checkBalanced(treeNode.right, 0);
		return Math.abs(left - right) <= 1;
	}

	private static int checkBalanced(TreeNode treeNode, int height) {
		if(treeNode == null) return height;		
		if(treeNode.left != null && treeNode.left.left != null && treeNode.right == null) return -1;	
		if(treeNode.right != null && treeNode.right.right != null && treeNode.left == null) return -1;
		height++;
		System.out.println("At node: " + treeNode.value + " with a height " + height);
		int leftHeight = checkBalanced(treeNode.left, height);
		int rightHeight = checkBalanced(treeNode.right, height);
		if(leftHeight != -1 && rightHeight != -1) {
			return Math.max(leftHeight, rightHeight);
		}else {
			return -1;
		}
	}

};