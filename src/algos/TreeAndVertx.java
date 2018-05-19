package algos;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TreeAndVertx {
	public int get(int[] tree) {
		Map<Integer, Integer> out = new HashMap<Integer, Integer>();
		for(int i=0; i<tree.length; i++) {
			out.merge(tree[i], 1, (o, n) -> { return o + 1; });
			out.merge(i+1, 1, (o, n) -> { return o + 1; });
		}		
		return(out.values().stream().max(Comparator.naturalOrder()).get());
	}
};