package algos;

import java.util.Arrays;

class ArrayMoveTheZeros {

	// https://leetcode.com/problems/rotate-array/description/

	public static void main(String[] args) {
		int[] in = new int[] { 1, 0, 5, 0, 2, 3, 0, 0, 0, 1 };
		new ArrayMoveTheZeros().moveZeroes(in);
		System.out.println(Arrays.toString(in));
	}

	public void moveZeroes(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			if (nums[i] != 0) {
				int k = i;
				while(k > 0 && nums[k - 1] == 0) {
					nums[k - 1] ^= nums[k];
					nums[k] ^= nums[k - 1];
					nums[k - 1] ^= nums[k];
					k--;
				}
			}
			i++;
		}
	}
}