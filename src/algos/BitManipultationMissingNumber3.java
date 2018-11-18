package algos;

import java.util.Arrays;

class BitManipultationMissingNumber3 {

	// https://leetcode.com/problems/single-number-ii/description/

	public static void main(String[] args) {
		int[] in = new int[] { 1, 2, 1, 3, 2, 5 };
		System.out.println(Arrays.toString(new BitManipultationMissingNumber3().singleNumber(in)));
	}

	// The approach is to ^ all of the numbers together, this will give us the XOR
	// of the two numbers which only occur once (call it 'A'), the rest will cancel
	// out. Once we have
	// 'A' we can say that in any given position where there is a 1 that the two
	// numbers which went
	// into creating 'A' must differ at that position, else when we XOR'd them we
	// would have
	// got a 0. With this information we can then split the list of numbers into the
	// ones
	// which have this bit set and the ones which don't. This split ensures all
	// pairs which cancel
	// out will be in the same set but the two numbers which only occur once will in
	// different sets.
	// if we then XOR each group we will be left with the two numbers only occurring
	// once.

	public int[] singleNumber(int[] nums) {
		int xorOrTwoNumbers = 0;
		int[] sol = new int[] { 0, 0 };
		for (int i = 0; i < nums.length; i++) {
			xorOrTwoNumbers ^= nums[i];
		}
		int highestSetBit = Integer.highestOneBit(xorOrTwoNumbers);
		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] & highestSetBit) != 0) {
				sol[0] ^= nums[i];
			} else {
				sol[1] ^= nums[i];
			}
		}
		return sol;
	}

}