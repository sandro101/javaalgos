package algos;

import java.util.Arrays;

class DPHouseRobber {

	public static void main(String[] args) {
		int[] testIntArry = new int[] { 1, 2, 1, 1 };
		System.out.println(rob(testIntArry));
	}

    public static int rob2(int[] nums) {
    	if (nums.length == 0) {
			return 0;
		}
    	if (nums.length == 1) {
			return nums[0];
		}
    	int[] maximumForEachNoOfHouses = new int[nums.length + 1];
    	maximumForEachNoOfHouses[0] = 0;
    	maximumForEachNoOfHouses[1] = nums[0];
    	
    	for (int i = 2; i <= nums.length; i++) {    		
			maximumForEachNoOfHouses[i] = Math.max(maximumForEachNoOfHouses[i-1], maximumForEachNoOfHouses[i-2] + nums[i - 1]);
		}
        return maximumForEachNoOfHouses[nums.length];
    }
    
    public static int rob(int[] nums) {
    	if (nums.length == 0) {
			return 0;
		}
    	if (nums.length == 1) {
			return nums[0];
		}
		return(Math.max(
			rob2(Arrays.copyOf(nums, nums.length-1)),
			rob2(Arrays.copyOfRange(nums, 1, nums.length))
		)); 
    }
}