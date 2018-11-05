package testers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionRunner {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new String[]{"hello", "world"}));
	}

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        backtrack(sol, 0, nums, new ArrayList<Integer>());
		return sol;
    }
    
    private void backtrack(List<List<Integer>> sol, int start, int[] nums, List<Integer> builder) {
        if(!sol.contains(builder)){
            sol.add(builder);
        } else {
            for(int i = start; i < nums.length; i++){
                builder.add(nums[i]);
                backtrack(sol, start + 1, nums, builder);
                builder.remove(builder.size() - 1);
            }
        }
    }
}