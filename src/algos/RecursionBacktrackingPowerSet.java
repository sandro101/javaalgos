package algos;

import java.util.ArrayList;
import java.util.List;

class RecursionBacktrackingPowerSet {

	public static void main(String[] args) {
		int[] testIntArry = new int[] { 1, 2, 3 };
		new RecursionBacktrackingPowerSet().subsets(testIntArry);
	}

    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> set = new ArrayList<>();
    	backtracking(set, new ArrayList<Integer>(), nums, 0);
		return set;
    }

	private void backtracking(List<List<Integer>> set, ArrayList<Integer> builderList, int[] nums, int start) {
		set.add(new ArrayList<Integer>(builderList));
		for (int i = start; i < nums.length; i++) {
			if(!builderList.contains(nums[i])) {
				builderList.add(nums[i]);
				backtracking(set, builderList, nums, start + 1);
				builderList.remove(builderList.size() - 1);
			}
		}
		
	}
}