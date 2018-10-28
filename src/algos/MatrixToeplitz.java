package algos;

class MatrixToeplitz {
	
	public static void main(String[] args) {
		int[][] testGrid = new int[][] { 
			{1,2,3,4},
			{5,1,2,3},
			{9,5,1,2} 
		};
		System.out.println( new MatrixToeplitz().isToeplitzMatrixRecursive(testGrid));
	}
	
    public boolean isToeplitzMatrix(int[][] matrix) {
        int numRows = matrix.length;
    	if(numRows == 1) {
    		return true;
    	}
        int[] tr = matrix[0];
        for (int i = 1; i < numRows; i++) {
			for (int j = 0; j < tr.length - 1; j++) {
				if(tr[j] != matrix[i][j + 1]) return false;
			}
			tr = matrix[i];
		}
        return true;
    }
    
    public boolean isToeplitzMatrixRecursive(int[][] matrix) {
    	return helper(matrix, 1);
    }
    
    private boolean helper(int[][] matrix, int row) {
        int numRows = matrix.length;
    	if(numRows == row) {
    		return true;
    	}
    	boolean flag = true;
		for (int j = 1; j < matrix[row].length; j++) {
			if(matrix[row][j] != matrix[row - 1][j - 1]) {
				flag = false;
				break;
			}
		}
    	return helper(matrix, row + 1) && flag;
    }
    
    

}