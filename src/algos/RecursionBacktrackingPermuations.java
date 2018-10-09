package algos;

import java.util.ArrayList;
import java.util.List;

class RecursionBacktrackingPermuations {

	public static void main(String[] args) {
		int[] testIntArry = new int[] { 1, 2, 3 };
		new RecursionBacktrackingPermuations().permute(testIntArry);
	}

	public List<List<Integer>> permute(int[] nums) {
		   List<List<Integer>> list = new ArrayList<>();
		   backtrack(list, new ArrayList<>(), nums);
		   return list;
		}

		private void backtrack(List<List<Integer>> list, List<Integer>builderList, int[] nums){
			if (builderList.size() == nums.length) {
				list.add(new ArrayList<Integer>(builderList));
			}
			else { 
				for (int i = 0; i < nums.length; i++) {
					if (!builderList.contains(nums[i])) {
						builderList.add(nums[i]);
						backtrack(list, builderList, nums);
						builderList.remove(builderList.size() - 1);
					}
				}
			}
		} 

}