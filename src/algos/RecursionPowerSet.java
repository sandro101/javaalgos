package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class RecursionPowerSet {

	public static void main(String[] args) {
		int[] testIntArry = new int[] { 1, 2, 3 };
		new RecursionPowerSet().subsets(testIntArry);
	}

    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> set = new ArrayList<>();
    	return helper(nums, set, 0, nums.length);
    }

	private List<List<Integer>> helper(int[] nums, List<List<Integer>> set, int size, int maxSize) {		
        if (nums.length == 0) {
        	if(!set.contains(new ArrayList<Integer>()))
        		set.add(new ArrayList<Integer>());
			return set;
		}
        for (int i = size; i < maxSize; i++) {
        	helper(removeElement(nums, i - size), set, size + 1, maxSize);
		}
        List<Integer> subSet = Arrays.stream(nums).boxed().collect(Collectors.toList());
        if(!set.contains(subSet))
        	set.add(subSet);
        return set;
	}
    
    private int[] removeElement(int[] original, int element) {
		int[] n = new int[original.length - 1];
		System.arraycopy(original, 0, n, 0, element);
		System.arraycopy(original, element + 1, n, element, original.length - element - 1);
		return n;
	}

}