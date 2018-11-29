package algos;

class ArrBestTimeToBuyAndSellStock2 {

	// 122 leetcode
	public int maxProfit(int[] nums) {
		int max = 0;
		boolean holding = false;
		
		// logic as follows:
		// if you are not holding anything and the price is going to go up at i + 1 then buy
		// because you will be able to see next time. If you are holding and the price is going
		// to go down next time then sell because you can always buy back at a lower price
		// finally if you're still holding at the end sell out on the last lot in the array
		
		// this works because you are always buying and selling knowing the price is going to go up or down 
		// in the i + 1 element.
		
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