package algos;

import java.util.Arrays;

class MatrixReshape {
	
	//https://leetcode.com/problems/reshape-the-matrix/description/
	
	public static void main(String[] args) {
		int[][] testGrid = new int[][] { 
			{1,2,3,4},
			{5,1,2,3},
			{9,5,1,2} 
		};
		System.out.println(Arrays.deepToString((new MatrixReshape().matrixReshape(testGrid, 2, 6))));
	}
	
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int rows = nums.length;
        int cols = nums[0].length;
        if(r * c != rows * cols) return nums;
        int[][] newM = new int[r][c];
        
        int cr = 0;
        int cc = 0;
        
        for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				newM[cr][cc] = nums[i][j];
				cc++;
				if(cc >= c) {
					cc = 0;
					cr++;
				}
			}
		}
        return newM;
    }   

}