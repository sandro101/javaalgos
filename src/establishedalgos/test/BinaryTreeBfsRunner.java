package establishedalgos.test;

import establishedalgos.Algos;
import establishedalgos.datastructures.BinaryTreeNode;

public class BinaryTreeBfsRunner {
	
	public static void main(String args[]) {
		BinaryTreeNode<Integer> tree = new BinaryTreeNode<Integer>(0);
		tree.left = new BinaryTreeNode<Integer>(1);
		tree.right = new BinaryTreeNode<Integer>(2);
		tree.left.left = new BinaryTreeNode<Integer>(3);
		tree.left.right = new BinaryTreeNode<Integer>(4);
		tree.right.left = new BinaryTreeNode<Integer>(5);
		tree.right.right = new BinaryTreeNode<Integer>(6);
		tree.right.left.left = new BinaryTreeNode<Integer>(7);
		tree.right.left.right = new BinaryTreeNode<Integer>(8);
		tree.right.right.left = new BinaryTreeNode<Integer>(9);
		
		Algos.bfsOfBinaryTree(tree);
	}
}
