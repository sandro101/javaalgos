package algos;

import java.util.ArrayList;
import java.util.List;

class RecursionBacktrackingPowerSet {

	public static void main(String[] args) {
		int[] testIntArry = new int[] { 1, 2, 3 };
		new RecursionBacktrackingPowerSet().subsets(testIntArry);
	}

    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> powerset = new ArrayList<>();
    	backtracking(powerset, new ArrayList<Integer>(), nums, 0);
		return powerset;
    }

	private void backtracking(List<List<Integer>> permutations, ArrayList<Integer> builderList, int[] nums, int start) {
		permutations.add(new ArrayList<Integer>(builderList));
		for (int i = start; i < nums.length; i++) {
			if(!builderList.contains(nums[i])) {
				builderList.add(nums[i]);
				backtracking(permutations, builderList, nums, start + 1);
				builderList.remove(builderList.size() - 1);
			}
		}
		
	}
}