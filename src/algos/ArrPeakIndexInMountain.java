package algos;

class ArrPeakIndexInMountain {

	public static void main(String[] args) {
		int[] testIntArry = new int[] { 0, 1, 0 };
		System.out.println(new ArrPeakIndexInMountain().peakIndexInMountainArray(testIntArry));
	}

	public int peakIndexInMountainArray(int[] A) {
		// There is a o(n) approach of just looping over array until a[i + 1] < a[i]
		int l = 0;
		int r = A.length - 1;
		while (l < r) {
			int mid = (l + r) / 2;
			if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
				return mid;
			}

			if (A[mid] > A[mid - 1]) {
				l = mid + 1;
			}

			if (A[mid] > A[mid + 1]) {
				r = mid;
			}
		}
		return -1;
	}

}