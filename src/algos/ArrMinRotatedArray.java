package algos;

class ArrMinRotatedArray {

	public static void main(String[] args) {
		int[] testIntArry = new int[] { 2, 3, 4, 5, 1 };
		System.out.println(findMin(testIntArry));
	}

	public static int findMin(int[] nums) {
		int l = 0;
		int r = nums.length - 1;
		if (r == 0)
			return nums[r];
		if (nums[r] > nums[0]) {
			return nums[0];
		}
		while (l <= r) {
			int m = (l + r) / 2;
			if (nums[m] > nums[m + 1]) {
				return nums[m + 1];
			}

			// if the m element is lesser than its previous element then m element is
			// the smallest
			if (nums[m - 1] > nums[m]) {
				return nums[m];
			}

			// if the m elements value is greater than the 0th element this means
			// the least value is still somewhere to the r as we are still dealing with
			// elements
			// greater than nums[0]
			if (nums[m] > nums[0]) {
				l = m + 1;
			} else {
				// if nums[0] is greater than the m value then this means the smallest value
				// is somewhere to
				// the l
				r = m - 1;
			}

		}
		return nums[l];
	}
}