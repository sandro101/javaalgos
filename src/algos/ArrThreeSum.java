package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ArrThreeSum {
	
	public static void main(String[] args) {
		int[] testIntArry = new int[] { -1,0,1,2,-1,-4 };
		threeSum(testIntArry);
	}

    public static List<List<Integer>> threeSum(int[] nums) {
    	if(nums.length < 3) return new ArrayList<List<Integer>>();
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	Map<Integer, List<List<Integer>>> complements = new HashMap<Integer, List<List<Integer>>>();
    	for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {				
				int complement = 0 - (nums[i] + nums[j]);
				List<List<Integer>> pairs = complements.getOrDefault(complement, new ArrayList<List<Integer>>());
				List<Integer> pair = new ArrayList<Integer>(Arrays.asList(nums[i], nums[j]));
				Collections.sort(pair);
				pairs.add(pair);
				complements.put(complement, pairs);				
			}
		}
    	for (int i = 0; i < nums.length; i++) {
			if(complements.containsKey(nums[i])) {
				List<List<Integer>> pairs = complements.get(nums[i]);
				if(pairs.size() > 0) {
					List<Integer> pair = new ArrayList<Integer>(pairs.get(0));
					pairs.removeAll(new ArrayList<List<Integer>>(Arrays.asList(pair)));
					pair.add(nums[i]);
					Collections.sort(pair);
					result.removeAll(new ArrayList<List<Integer>>(Arrays.asList(pair)));
					result.add(pair);
					complements.put(nums[i], pairs);
				}
				
			}
		}
		return result;
        
    }
}