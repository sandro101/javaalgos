package algos;

class BitManipulationsHammingDistance {
	
	public static void main(String[] args) {
		System.out.println(new BitManipulationsHammingDistance().hammingDistance(1, 4));
	}
	
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int c = 0;
        for (int i = 0; i < 32; i++) {
			if((xor & (1 << i)) != 0) {
				c++;
			}
		}
        return c;
    }
    
    public int hammingDistance2(int x, int y) {
        int xor = x ^ y;
        int c = 0;
        for (int i = 0; i < 32; i++) {
			if((xor >> i & 1) != 0) {
				c++;
			}
		}
        return c;
    }
}