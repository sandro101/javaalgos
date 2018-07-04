package establishedalgos.test;

import establishedalgos.Algos;
import establishedalgos.datastructures.TreeNode;

public class TreeBfsRunner {
	
	public static void main(String args[]) {
		TreeNode<Integer> root = new TreeNode<Integer>(0);
		TreeNode<Integer> one = new TreeNode<Integer>(1);
		TreeNode<Integer> two = new TreeNode<Integer>(2);
		TreeNode<Integer> three = new TreeNode<Integer>(3);
		TreeNode<Integer> four = new TreeNode<Integer>(4);
		TreeNode<Integer> five = new TreeNode<Integer>(5);
		TreeNode<Integer> six = new TreeNode<Integer>(6);
		TreeNode<Integer> seven = new TreeNode<Integer>(7);
		TreeNode<Integer> eight = new TreeNode<Integer>(8);
		TreeNode<Integer> nine = new TreeNode<Integer>(9);
		TreeNode<Integer> ten = new TreeNode<Integer>(10);
		TreeNode<Integer> eleven = new TreeNode<Integer>(11);
		
		eight.addChild(nine);
		eight.addChild(ten);
		eight.addChild(eleven);
		
		six.addChild(seven);
		
		five.addChild(six);
		five.addChild(eight);
		
		one.addChild(three);
		one.addChild(four);
		one.addChild(five);
		
		root.addChild(one);
		root.addChild(two);		
		Algos.bfsOfTree(root);
	}
}
