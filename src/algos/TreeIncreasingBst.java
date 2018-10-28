package algos;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class TreeIncreasingBst {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

    public TreeNode increasingBST(TreeNode root) {
    	// This code takes a node traverses down to the left to see if that is the
    	// largest or smallest node and the produces a new tree of right-only
    	// nodes from either smallest to largest or largest to smallest
    	if(root == null) return root;
    	TreeNode runner = root;
    	while(runner.left != null) {
    		runner = runner.left;
    	}
    	Queue<Integer> heap;
    	if(runner.val <= root.val) {
    		heap = new PriorityQueue<>();
    	} else {
    		heap = new PriorityQueue<>(Collections.reverseOrder());
    	} 
        walk(root, heap);
        TreeNode p = new TreeNode(heap.poll());
        TreeNode h = p;
        while(!heap.isEmpty()) {
        	p.right = new TreeNode(heap.poll());
        	p = p.right;
        }
        return h;
    }

	private void walk(TreeNode root, Queue<Integer> heap) {
		if(root != null) {
			walk(root.left, heap);
			heap.add(root.val);
			walk(root.right, heap);
		}
	}
};