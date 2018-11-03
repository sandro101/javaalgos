package algos;

import java.util.Arrays;

class ArrayInvertMatrix {
	
	public static void main(String[] args) {
		int[][] testGrid = new int[][] { {1,1,0},{1,0,1},{0,0,0} };
		System.out.println(Arrays.toString(new ArrayInvertMatrix().flipAndInvertImage(testGrid)));
	}
	
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
			reverseAndInvert(A[i]);
		}
        return A;
    }

	private void reverseAndInvert(int[] row) {
		reverse(row);
		invert(row);
	}

	private void invert(int[] row) {
		for (int i = 0; i < row.length; i++) {
			// flip all the ones to zeros
			row[i] = Math.abs(row[i] - 1);
		}		
	}

	private void reverse(int[] row) {
		for (int i = 0; i < row.length / 2; i++) {
			// reverse the rows
			int temp = row[i];
			row[i] = row[row.length - i - 1];
			row[row.length - i - 1] = temp;
		}
	}

}