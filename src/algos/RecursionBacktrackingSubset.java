package algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// https://leetcode.com/problems/subsets/description/

class RecursionBacktrackingSubset {

	public static void main(String[] args) {
		int[] testIntArry = new int[] { 1, 2, 2 };
		System.out.println(new RecursionBacktrackingSubset().subsets(testIntArry));
	}

	public List<List<Integer>> subsets(int[] nums) {
		Set<List<Integer>> sol = new HashSet<>();
		backtrack(sol, 0, nums, new ArrayList<Integer>());
		return sol.stream().collect(Collectors.toList());
	}

	private void backtrack(Set<List<Integer>> sol, int start, int[] nums, List<Integer> builder) {
		List<Integer> l = new ArrayList<>(builder);
		Collections.sort(l);
		sol.add(l);
		for (int i = start; i < nums.length; i++) {
			builder.add(nums[i]);
			backtrack(sol, start + 1, nums, builder);
			builder.remove(builder.size() - 1);
		}
	}
}