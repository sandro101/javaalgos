package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TriangleEasy {
	public int find(int v, int[] x, int[] y) {
		Map<Integer, List<Integer>> out = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < x.length; i++) {
			final int a = i;
			out.merge(x[i], new ArrayList<Integer>(Arrays.asList(y[i])), (o, n) -> {
				o.add(y[a]);
				return o;
			});
			out.merge(y[i], new ArrayList<Integer>(Arrays.asList(x[i])), (o, n) -> {
				o.add(x[a]);
				return o;
			});
		}
		return edgesRequired(out);
	}

	private int edgesRequired(Map<Integer, List<Integer>> out) {
		int maxSize = 0;
		int additionalEdges = 1;
		for (List<Integer> connectedNodes : out.values()) {
			maxSize = Math.max(maxSize, connectedNodes.size());
			if (maxSize >= 2) {
				for(int node: connectedNodes) {
					if(!Collections.disjoint(out.get(node), connectedNodes)) {
						additionalEdges = 0;
						break;
					}
				}
			}
		}
		switch (maxSize) {
		case 0:
			return 3;
		case 1:
			return 2;
		default:
			return additionalEdges;
		}
	}
};