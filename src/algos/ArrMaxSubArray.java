package algos;

class ArrMaxSubArray {
	
	// Maximum sum from a sub array. Key is keep adding until it flips negative, if it flips
	// negative you know you should start your sum again
	
	public static void main(String[] args) {
		System.out.println(maxSubDynamic(new int[] { 1, 10, -7, 12, -100, 1, 10 }));
	}

	public static int maxSubArray(int[] nums) {
		if(nums.length == 1) return nums[0];
		int i = 0;
		int max = Integer.MIN_VALUE;
		while (i < nums.length) {
			max = Math.max(max, nums[i]);
			int sum = nums[i];
			i++;
			while (sum > 0 && i < nums.length) {
				sum = sum + nums[i];
				max = Math.max(sum, max);
				i++;
			}
		}
		return max;
	}
	
	public static int maxSubDynamic(int[] nums) {
        int biggestRunningSum = nums[0], currentRunningSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
        	currentRunningSum = (currentRunningSum < 0) ? nums[i] : currentRunningSum + nums[i];
            biggestRunningSum = Math.max(biggestRunningSum, currentRunningSum);
        }
        return biggestRunningSum;		
	}
}