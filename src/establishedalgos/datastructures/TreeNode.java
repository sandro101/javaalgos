package establishedalgos.datastructures;

import java.util.LinkedList;

public class TreeNode<T> {
	public LinkedList<TreeNode<T>> children;
	public T data;
	
	public TreeNode(T data){
		this.data = data;
		this.children = new LinkedList<TreeNode<T>>();
	}
	
	public void addChild(TreeNode<T> child) {
		this.children.add(child);
	}
}
