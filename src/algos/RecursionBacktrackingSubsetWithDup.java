package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// https://leetcode.com/problems/subsetsWithDup/description/

class RecursionBacktrackingSubsetWithDup {

	public static void main(String[] args) {
		int[] testIntArry = new int[] { 1, 2, 3 };
		System.out.println(new RecursionBacktrackingSubsetWithDup().subsetsWithDup(testIntArry));
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Set<List<Integer>> sol = new HashSet<>();	
		Map<Integer, Long> counts = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(x->x, Collectors.counting()));
		backtrack(sol, 0, nums, new ArrayList<Integer>(), counts);
		return sol.stream().collect(Collectors.toList());
	}

	private void backtrack(Set<List<Integer>> sol, int start, int[] nums, List<Integer> builder, Map<Integer, Long> counts) {
		List<Integer> l = new ArrayList<>(builder);
		Collections.sort(l);
		sol.add(l);
		for (int i = start; i < nums.length; i++) {
			if (containsOnlyValsInNums(counts, builder, nums[i])) {
				builder.add(nums[i]);
				backtrack(sol, start + 1, nums, builder, counts);
				builder.remove(builder.size() - 1);
			}
		}
	}

	private boolean containsOnlyValsInNums(Map<Integer, Long> counts, List<Integer> builder, int i) {
		return counts.get(i) > builder.stream().filter(x-> x == i).count();	
	}
}