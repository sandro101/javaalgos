package algos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TreeSubtreeSum {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeSubtreeSum().new TreeNode(5);
		TreeNode n2 = new TreeSubtreeSum().new TreeNode(2);
		TreeNode n3 = new TreeSubtreeSum().new TreeNode(-3);
		n1.left = n2;
		n1.right = n3;
		System.out.println(Arrays.toString(new TreeSubtreeSum().findFrequentTreeSum(null)));
	}

	public int[] findFrequentTreeSum(TreeNode root) {
		if(root == null) return new int[1];
		Map<Integer, Integer> freq = new HashMap<>();
		dfs(root, freq);
		int maxCount = freq.values().stream().mapToInt(x->x).max().getAsInt();
		return freq.keySet().stream()
			.filter(k -> freq.get(k) == maxCount)
			.mapToInt(i -> i).toArray();
	}

	private int dfs(TreeNode root, Map<Integer, Integer> freq) {
		if(root == null) return 0;
		int sum = root.val + dfs(root.left, freq) + dfs(root.right, freq);
		freq.put(sum, freq.getOrDefault(sum, 0) + 1);
		return sum;
	}
};