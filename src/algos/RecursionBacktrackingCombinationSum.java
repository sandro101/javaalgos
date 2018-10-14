package algos;

import java.util.ArrayList;
import java.util.List;

class RecursionBacktrackingCombinationSum {

	public static void main(String[] args) {
		int[] testIntArry = new int[] { 1, 2, 3 };
		new RecursionBacktrackingCombinationSum().combinationSum(testIntArry, 3);
	}

	public List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		backtracker(list, new ArrayList<>(), nums, target, 0);
		return list;
	}

	private void backtracker(List<List<Integer>> list, List<Integer> builderList, int[] nums, int target, int start) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			list.add(new ArrayList<Integer>(builderList));
		} else {
			for (int i = start; i < nums.length; i++) {
				builderList.add(nums[i]);
				backtracker(list, builderList, nums, target - nums[i], i);
				builderList.remove(builderList.size() - 1);				
			}
		}
	}

}