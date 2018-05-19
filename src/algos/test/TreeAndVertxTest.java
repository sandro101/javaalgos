package algos.test;

import algos.TreeAndVertx;

public class TreeAndVertxTest {

	public static void main(String[] args) {	
		int[] input = {0, 0, 1, 2, 0, 0, 3, 5, 5, 0, 2, 2, 5, 8, 5, 7, 5, 0, 13, 2, 19, 12, 2, 0, 10, 23, 14, 3, 28, 1, 2, 9, 8, 1, 18, 27, 36, 30, 16, 30, 2, 19, 21, 33, 30, 13, 38, 40, 33, 36, 20, 0, 25, 49, 41, 32, 27, 43, 34};
		System.out.println(new TreeAndVertx().get(input));
	}
}
