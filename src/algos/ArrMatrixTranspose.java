package algos;

class ArrMatrixTranspose {
	
	public static void main(String[] args) {
		int[][] testGrid = new int[][] { {1,2,3},{4,5,6} };
		System.out.println(new ArrMatrixTranspose().transpose(testGrid));
	}

    public int[][] transpose(int[][] A) {
    	int[][] sol = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
            	sol = transpose(A, sol, i, j);
    		}
		}
        return sol;
    }
    
    private int[][] transpose(int[][] A, int[][] sol, int row, int col){
    	sol[col][row] = A[row][col];
    	return sol;
    }
}