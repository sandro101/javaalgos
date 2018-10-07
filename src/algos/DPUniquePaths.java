package algos;

class DPUniquePaths {

	public static void main(String[] args) {
		System.out.println(uniquePaths(2, 3));
	}

    public static int uniquePaths(int m, int n) {
    	// m rows and n columns
        int[][] numberOfPathsToSquare = new int[m][n];
        for (int i = 0; i < n; i++) {
        	numberOfPathsToSquare[0][i] = 1;
		}
        for (int i = 0; i < m; i++) {
        	numberOfPathsToSquare[i][0] = 1;
		}
        
        for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				numberOfPathsToSquare[i][j] = numberOfPathsToSquare[i][j - 1] + numberOfPathsToSquare[i - 1][j];
			}
		}
        
        return numberOfPathsToSquare[m - 1][n - 1];
    }
}