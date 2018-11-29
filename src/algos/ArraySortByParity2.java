package algos;

class ArraySortByParity2 {
	
	//https://leetcode.com/problems/sort-array-by-parity-ii/description/
	
	//Sort array so that all of the A[i] numbers where i is odd are odd and similarly
	//where A[i] is even
	
	//Set even pointer (e) to point at 0th element in array and set odd pointer (o) to point at
	//1st position in array. Every time an odd number is encountered place it at o and increment by 2
	//similarly for even
	
    public int[] sortArrayByParityII(int[] A) {
        int[] B = new int[A.length];
        int e = 0;
        int o = 1;
        for (int i = 0; i < A.length; i++) {
			if((A[i] & 1) == 1) {
				B[o] = A[i];
				o+=2;
			} else {
				B[e] = A[i];
				e+=2;
			}
		}
        return B;
    }

}