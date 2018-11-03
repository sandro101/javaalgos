package algos;

import java.util.HashSet;
import java.util.Set;

class ArrContainsDuplicate {
	public static void main(String[] args) {
		containsDuplicate(new int[] {1, 2, 3, 1});
	}
	
	//O(N) contains dupes	
    public static boolean containsDuplicate(int[] nums) {
    	Set<Integer> counts = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
        	if(counts.contains(nums[i])) {
        		return true;
        	} else {
        		counts.add(nums[i]);
        	}
        }
        return false;
    }
}