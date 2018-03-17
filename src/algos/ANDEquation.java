package algos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ANDEquation {

	public int restoreY(int[] arr) {
		List<Integer> l = Arrays.stream(arr).boxed().collect(Collectors.toList());
		for (int i = 0; i < l.size(); i++) {
			int val = l.remove(i);
			int out = applyAnd(l);
			if (((Integer) val).equals(out)) {
				return val;
			};
		}
		return -1;
	}

	private int applyAnd(List<Integer> arr) {
		if (arr.size() == 2)
			return arr.get(0) & arr.get(1);
		
		return arr.stream().reduce(arr.get(0), (acc, val) -> {
			return acc & val;
		});
	}
};