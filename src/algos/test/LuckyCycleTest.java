package algos.test;

import algos.LuckyCycle;

public class LuckyCycleTest {
	public static void main(String[] args) {
		//int[] edge1 = new int[]{1, 2, 3, 5, 6};
		//int[] edge2 = new int[]{2, 3, 4, 3, 5};
		//int[] weight = new int[]{4, 7, 7, 7, 7};

		int[] edge1 = new int[] {1, 3, 2, 4};
		int[] edge2 = new int[] {2, 2, 4, 5};
		int[] weight = new int[] {4, 7, 4, 7};
		
		
		//int[] edge1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		//int[] edge2 = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		//int[] weight = new int[]{4, 4, 4, 4, 4, 4, 7, 7, 7, 7, 7, 7};
		
		int[] out = new LuckyCycle().getEdge(edge1, edge2, weight);
		System.out.printf("%s %s %s", out[0], out[1], out[2]);
	}
}
