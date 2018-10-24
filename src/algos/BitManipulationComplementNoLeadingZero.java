package algos;

class BitManipulationComplementNoLeadingZero {
	
	public static void main(String[] args) {
		System.out.println(new BitManipulationComplementNoLeadingZero().findComplement(Integer.MAX_VALUE));
	}
	
    public int findComplement(int num) {
    	int mask = 0;
    	int k = 0;
    	int iNum = num;
        while(num/2 > 0) {        	
        	mask |= 1<<k;
        	k++;
            num = num / 2;
        }
        mask |= 1<<k;
        return ~iNum & mask;
    }
    
}