package algos;

import java.util.Arrays;

class ArrayRotate {

	// https://leetcode.com/problems/rotate-array/description/
	
	public static void main(String[] args) {
		int[] in = new int[] { 1, 2, 3, 4, 5, 6 };
		new ArrayRotate().rotateInPlace(in, 3);
		System.out.println(Arrays.toString(in));
	}

	public int[] rotate(int[] nums, int k) {
		int[] rotated = new int[nums.length];
		for(int i = 0; i < nums.length; i++) {
			int pos = (i + k) % nums.length;
			System.out.println(pos);
			rotated[pos] = nums[i];
		}
		return rotated;
	}
	
	public void rotateInPlace(int[] nums, int k) {
		int ll = nums.length - (k % nums.length);
		
		int j = ll - 1;
		for(int i = 0; i < ll/2; i++) {
			reverse(nums, j, i);
			j--;
		}
		j = nums.length - 1;
		for(int i = ll; i < (nums.length + ll)/2; i++) {
			reverse(nums, j, i);
			j--;
		}
		j = nums.length - 1;
		for (int i = 0; i < nums.length / 2; i++) {
			reverse(nums, j, i);
			j--;
		}
	}

	private void reverse(int[] nums, int j, int i) {
		nums[i] ^= nums[j];
		nums[j] ^= nums[i];
		nums[i] ^= nums[j];
	}

}