package testers;

import java.util.Arrays;
import java.util.stream.IntStream;

class SolutionRunner {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new String[]{"hello", "world"}));
	}

	private static void zeroOutRow(int row, int[][] testGrid) {
		for(int i = 0; i < testGrid[row].length; i++) {
			testGrid[row][i] = 0;
		}		
	}
	
	private static void zeroOutColumn(int col, int[][] testGrid) {
		for(int i = 0; i < testGrid.length; i++) {
			testGrid[i][col] = 0;
		}		
	}
}