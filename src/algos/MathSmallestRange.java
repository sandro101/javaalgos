package algos;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

class MathSmallestRange {

	public static void main(String[] args) {
		int[] testIntArry = new int[] { -5, 3, 8, 10 };
		System.out.println(new MathSmallestRange().smallestRangeI(testIntArry, 7));
	}

	public int smallestRangeI(int[] A, int K) {
		IntSummaryStatistics summary = Arrays.stream(A).summaryStatistics();
		int max = summary.getMax();
		int min = summary.getMin();

		return Math.max((max - min) - 2 * K, 0);
	}

}