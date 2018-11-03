package algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TreeAvgValueOfLeve {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

    public List<Double> averageOfLevels(TreeNode root) {
    	List<Double> sol = new ArrayList<>();
    	if(root == null) return sol;
    	Queue<TreeNode> nodes = new LinkedList<>();
    	Map<Integer, Integer> levels = new HashMap<>();
        nodes.add(root);
        int l = 0;
        levels.put(l, 1);
        while(!nodes.isEmpty()) {
        	Integer nNodes = levels.get(l);
        	int count = 0;
        	double lTotal = 0;
        	while(nNodes > 0) {
            	TreeNode n = nodes.poll();            	
            	if(n.left != null) {
            		nodes.add(n.left);            		
            		levels.put(l + 1, levels.getOrDefault(l + 1, 0) + 1);
            	}
            	if(n.right != null) {
            		nodes.add(n.right);
            		levels.put(l + 1, levels.getOrDefault(l + 1, 0) + 1);
            	}  
            	lTotal += n.val;
            	count++;
            	nNodes--;
        	}
        	sol.add(lTotal / count);
        	l++;      	
        }
        return sol;
    }
};