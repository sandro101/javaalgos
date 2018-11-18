package algos;

class BitManipulationMissingNumber2 {

	// https://leetcode.com/problems/single-number-ii/description/
	
	public static void main(String[] args) {
		int[] in = new int[] { 1, 2, 2, 1, 1, 2, 3, 4, 4, 4, 5, 5, 5 };		
		System.out.println(new BitManipulationMissingNumber2().singleNumber(in));
	}
	
	// The approach is to count how many times a 1 appears in each position across
	// all of the numbers. If all of the numbers appeared 3 times then the number of
	// ones in any given position must be divisible by 3. This therefore means that in whichever
	// position there is a count of ones which is not divisible by 3 that the number which only
	// appears twice must have a 1 in that position. Hence we set that bit in the solution.

    public int singleNumber(int[] nums) {
    	int ans = 0;
        for(int i = 0; i < 32; i++) {
        	int countOnes = 0;
        	for (int j = 0; j < nums.length; j++) {
				if((nums[j] & (1 << i)) != 0) {
					countOnes++;
				}
			}
        	if(countOnes % 3 != 0) {
        		ans |= (1 << i);
        	}
        }
		return ans;
    }

}