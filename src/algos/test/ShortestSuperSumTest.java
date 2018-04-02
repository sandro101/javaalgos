package algos.test;

import algos.ShortestSuperSum;

public class ShortestSuperSumTest {

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		System.out.println(new ShortestSuperSum().calculate(10, 10));
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
	}
}
