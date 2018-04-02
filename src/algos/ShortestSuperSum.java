package algos;

public class ShortestSuperSum {
	public int calculate(int k, int n) {
		if (k == 0) {
			return n;
		}
		int sum = 0;
		for (int i = n; i >= 1; i--) {
			sum += calculate(k - 1, i);
		}		
		return sum;
	}
}


