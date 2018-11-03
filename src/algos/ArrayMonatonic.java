package algos;

class ArrayMonatonic {
	
	//https://leetcode.com/problems/monotonic-array/description/
	
	public static void main(String[] args) {
		int[] a = new int[] { 10, 10, 4, 4, 2, 2, 1 };
		System.out.println(new ArrayMonatonic().isMonotonic(a));
	}

    public boolean isMonotonic(int[] a) {
    	if(a.length < 2) return true;
    	boolean inc = false;
    	boolean dec = false;
        for (int i = 0; i < a.length - 1; i++) {
        	if(a[i + 1] > a[i]) {
        		inc = true;
        	}
        	if(a[i + 1] < a[i]) {
        		dec = true;
        	}
        	if(inc && dec) return false;
		}
    	return true;
    }
}