package algos.test;
import algos.BalancedTree;
import algos.TreeNode;

public class BalancedTreeTest {
	TreeNode root;

	private TreeNode createTree() {
		
/*
         0
   1           2
3    4      5     10
  6      12     7    11
    8		       13
*/
		
		this.root = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		TreeNode n11 = new TreeNode(11);
		TreeNode n12 = new TreeNode(12);
		TreeNode n13 = new TreeNode(13);
		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n10;
		n10.right = n11;
		n11.left = n13;
		n3.right = n6;
		n3.left = n9;
		n5.right = n7;
		n5.left = n12;
		n6.right = n8;
		return root;
	}
	
	public static void main(String[] args) {		
		System.out.println(BalancedTree.isTreeBalanced(new BalancedTreeTest().createTree()));
	}
};

