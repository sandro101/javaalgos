package algos;

import java.util.Arrays;

class MatrixMultiply {
	
	public static void main(String[] args) {
		int[][] A = new int[][] { 
			{1,2,3},
			{4,5,6},
		};
		
		int[][] B = new int[][] { 
			{7, 8},
			{9, 10},
			{11,12}, 
		};
		System.out.println(Arrays.deepToString((new MatrixMultiply().multiply(A, B))));
	}
	
    public int[][] multiply(int[][] A, int[][] B) {
    	if(A.length != B[0].length) return new int[0][0];
		int[][] S = new int[B[0].length][A.length];
    	for (int i = 0; i < A.length; i++) { // go across each row of A
			for (int j = 0; j < B[0].length; j++) { // go down each column of B
				for (int k = 0; k < B.length; k++) { 
					S[i][j] += A[i][k] * B[k][j];
				}
			}
		}
    	return S;
    }
    	

}