package algos;

import java.util.LinkedList;
import java.util.Queue;

class GraphMergeTrees {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        Queue<TreeNode[]> queue = new LinkedList<TreeNode[]>();
        queue.offer(new TreeNode[] {t1, t2});
        while (!queue.isEmpty()) {
            TreeNode[] t = queue.poll();
            if (t[0] == null || t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
            if (t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                queue.offer(new TreeNode[] {t[0].left, t[1].left});
            }
            if (t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                queue.offer(new TreeNode[] {t[0].right, t[1].right});
            }
        }
        return t1;
    }
}