package algos;

class ArraySortByParity {
	
	//https://leetcode.com/problems/sort-array-by-parity/description/
	
	//Sort array in order of parity, i.e. odd numbers first then even
	
	//This can be done with two pointers, one at the front and one at the back, i.e.
	//the odd (o) and even (e) pointers. If the number is odd then insert it into
	// the front of the array and increment o, otherwise insert it at the end
	//of the array and decrement e.
	
    public int[] sortArrayByParity(int[] A) {
        int[] B = new int[A.length];
        int o = 0;
        int e = A.length - 1;
        for (int i = 0; i < A.length; i++) {
			if((A[i] & 1) == 1 /*if odd*/) {
				B[o] = A[i];
				o++;
			} else {
				B[e] = A[i];
				e--;
			}
		}
        return B;
    }

}