package algos;

import java.util.Arrays;

class ArraysFindRange {

	public static void main(String[] args) {
		int[] testIntArry = new int[] { 1, 2, 3 };
		System.out.println(Arrays.toString(new ArraysFindRange().searchRange(testIntArry, 2)));
	}

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