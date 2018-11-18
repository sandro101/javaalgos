package algos;

class ArrayFindDupe {

	// https://leetcode.com/problems/find-the-duplicate-number/description/

	public static void main(String[] args) {
		int[] testIntArry = new int[] { 3, 4, 2, 2, 2, 2, 2, 1 };
		System.out.println(new ArrayFindDupe().findDuplicate(testIntArry));
	}

	// general approach is to count how many numbers are smaller than m.
	// if there are less than or equal to m numbers smaller than m then we know
	// that the dupe number must be larger than m. Keep repeating this until
	// l is no longer smaller than h, this means you have found the duplicate number
	// return l.

	public int findDuplicate(int[] nums) {
		int l = 1;
		int h = nums.length - 1;
		int m = 0;
		while (l < h) {
			m = (l + h) / 2;
			int c = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] <= m)
					c++;
			}
			if (c <= m) {
				l = m + 1;
			} else {
				h = m;
			}
		}
		return h;
	}

}