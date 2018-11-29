package algos;

import java.util.Arrays;

class ArraysFindRange {

	// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
	
	public static void main(String[] args) {
		int[] testIntArry = new int[] { 1, 2, 2, 2, 2, 2, 2, 2, 3 };
		System.out.println(Arrays.toString(new ArraysFindRange().searchRange(testIntArry, 2)));
	}
	
	// approach is to binary search until we find the position of the target on the left.
	// once we have found this we then insert that into the first part of the solution and work from there
	// right along the array until we find the end of the repeating section of the target and
	// add this as the second part of the solution

	public int[] searchRange(int[] nums, int target) {

		int i = 0;
		int j = nums.length - 1;
		int mid = -1;
		int[] sol = new int[2];
		Arrays.fill(sol, -1);
		if (nums.length == 0)
			return sol;
		while (i < j) {
			mid = (i + j) / 2;
			if (target > nums[mid]) {
				i = mid + 1;
			}
			if (nums[mid] == target) {
				// this is required because we need to find the leftmost position of the target, not just
				// any position
				if (mid - 1 < 0 || nums[mid - 1] != target) {
					i = mid;
					break;
				}
				j = mid - 1;
			}
			if (target < nums[mid]) {
				j = mid - 1;
			}
		}
		sol[0] = nums[i] == target ? i : -1;
		j = nums.length - 1;
		mid = i;
		while (i < j) {
			mid = 1 + (i + j) / 2;
			if (target > nums[mid]) {
				i = mid + 1;
			}
			if (nums[mid] == target) {
				// this is required because we need to find the leftmost position of the target, not just
				// any position
				if (mid + 1 > nums.length - 1 || nums[mid + 1] != target) {
					j = mid;
					break;
				}
				i = mid + 1;
			}
			if (target < nums[mid]) {
				j = mid - 1;
			}
		}
		sol[1] = nums[j] == target ? j : -1;
		return sol;
	}
}