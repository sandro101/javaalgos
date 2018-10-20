package testers;

class SolutionRunner {

	public static void main(String[] args) {
		int[][] testGrid = new int[][] { {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5} };
		zeroOutRow(1, testGrid);
		zeroOutColumn(2, testGrid);
		int a = 1;
		
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