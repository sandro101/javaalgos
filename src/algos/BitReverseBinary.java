package algos;

class BitReverseBinary {
	
	public static void main(String[] args) {
		System.out.println(reverseBits(43261596));
	}
	
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 31; i >= 0; i--) {
			if ((n & (1<<i)) != 0) {
				res |= (1<<31 - i);
			} 
		}
        return res;
    }
}