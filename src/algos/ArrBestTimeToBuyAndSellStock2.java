package algos;

class ArrBestTimeToBuyAndSellStock2 {

	// 122 leetcode
	public int maxProfit(int[] nums) {
		int max = 0;
		boolean holding = false;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1] && holding) {
				max += nums[i];
				holding = false;
			}
			if (nums[i + 1] > nums[i] && !holding) {
				max -= nums[i];
				holding = true;
			}
		}
		if (holding) {
			max += nums[nums.length - 1];
		}
		return max;
	}
}