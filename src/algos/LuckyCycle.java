package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LuckyCycle {
	public int[] getEdge(int[] edge1, int[] edge2, int[] weight) {
		// Keep walking along edges until we find a minimum of three connected n and n-1
		// weights
		Map<Integer, ArrayList<String>> tree = new HashMap<Integer, ArrayList<String>>();
		for (int i = 0; i < edge1.length; i++) {
			final int a = i;
			tree.merge(edge1[i], new ArrayList<String>(Arrays.asList(edge2[i] + "-" + weight[i])), (o, n) -> {
				o.add(edge2[a] + "-" + weight[a]);
				return o;
			});
		}
		List<Integer> out = traverse(tree, tree.get(1), new ArrayList<Integer>(Arrays.asList(1)), 0, 0);
		if(out.size() > 1) {
			return new int[] {out.get(0), out.get(out.size() - 3), out.get(out.size() - 2)};
		}
		else {
			return new int[] {};
		}
		
	}

	private List<Integer> traverse(Map<Integer, ArrayList<String>> tree, ArrayList<String> connections,
			List<Integer> nodes, int sevens, int fours) {
		for (String conn : connections) {
			int node = Integer.parseInt(conn.split("-")[0]);
			int weight = Integer.parseInt(conn.split("-")[1]);
			nodes.add(node);
			if (weight == 7) {
				sevens++;
			} else {
				fours++;
			}
			if (nodes.size() >= 4 && Math.abs(sevens - fours) == 1) {
				if (sevens - fours > 0) {
					nodes.add(4);
				} else {
					nodes.add(7);
				}
				nodes.add(0);
				return nodes;
			}
			if (tree.containsKey(node)) {
				traverse(tree, tree.get(node), nodes, sevens, fours);
			}
		}
		return nodes.lastIndexOf(0) == -1 ? new ArrayList<Integer>() : nodes;
	}
}
