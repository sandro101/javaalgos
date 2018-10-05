package algos;

class ArrTwoSum {

    public int[] twoSum(int[] nums, int target) {
    	//Can be done in O(n) by storing the complement in map and waiting to hit it on the way through the array
        for(int i = 0; i < nums.length; i++) {
        	for(int j = i; j < nums.length; j++) {
        		if(nums[i] + nums[j] == target) {
        			return new int[] {nums[i], nums[j]};
        		}
        	}
        }
        return null;
    }
}