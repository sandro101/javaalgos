package algos;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class ArrFindShortestSubArray {
	
	public static void main(String[] args) {
		int[] testIntArry = new int[] { 1, 2, 2, 3, 1, 4, 2 };
		System.out.println(new ArrFindShortestSubArray().findShortestSubArray(testIntArry));
	}
	
    public int findShortestSubArray(int[] nums) {
    	Map<Integer, Integer> leftPos = new HashMap<>();
    	Map<Integer, Integer> rightPos = new HashMap<>();
    	Map<Integer, Integer> counts = new HashMap<>();
    	
    	for (int i = 0; i < nums.length; i++) {
			if(!leftPos.containsKey(nums[i])) {
				leftPos.put(nums[i], i);
			}
			rightPos.put(nums[i], i);
			counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);			
		}
    	
    	int max = counts.values().stream().max(Comparator.naturalOrder()).get().intValue();
    	int min = Integer.MAX_VALUE;
    	for (int num : counts.keySet()) {
			if(counts.get(num) == max) {
				min = Math.min(rightPos.get(num) - leftPos.get(num) + 1, min);
			}
		}
    	return min;    	
    }


}