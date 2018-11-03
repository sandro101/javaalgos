package algos;

class ArraySortByParity {
	
	//Sort array in order of parity, i.e. odd numbers first then even
	
    public int[] sortArrayByParity(int[] A) {
        int[] B = new int[A.length];
        int s = 0;
        int e = A.length - 1;
        for (int i = 0; i < A.length; i++) {
			if((A[i] & 1) == 0 /*if odd*/) {
				B[s] = A[i];
				s++;
			} else {
				B[e] = A[i];
				e--;
			}
		}
        return B;
    }

}