package algos;

class BitSumOfTwoNumbers {
	
	public int getSum(int a, int b) {
		if (a == 0) return b;
		if (b == 0) return a;

		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		
		return a;
	}
    
    public int getSumRecursive(int a, int b) {
    	return (b == 0) ? a : getSumRecursive(a ^ b, (a & b) << 1);
    }
}