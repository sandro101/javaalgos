package algos;

class ArraySortByParity2 {
	
	//Sort array so that all of the A[i] numbers where i is odd are odd and similarly
	//where A[i] is even
	
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