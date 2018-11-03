package algos;

class BitManipulationAlternating1sAnd0s {
	
	//https://leetcode.com/problems/binary-number-with-alternating-bits/description/
	
	public static void main(String[] args) {
		System.out.println(new BitManipulationAlternating1sAnd0s().hasAlternatingBits(8));
	}
	
    public boolean hasAlternatingBits(int n) {
    	if(n < 1) return false;
    	int c = -1;
    	int p = -1;
        for (int i = n; i > 0; i/=2) {
			c = i % 2;
			if(p != -1) {				
				if(c == p) return false;
			}
			p = c;
		}
        return true;
    }
    
}