package algos;

class BitSumOfTwoNumbers {
	
    public int getSum(int a, int b) {
        if (a == 0) {
        	return b;			
		}
        if (b == 0) {
        	return a;		
		}
        int carry = 0;
        while(b != 1) {
        	carry = (a & b) << 1; // anywhere I have a carry shift it left
        	a = a ^ b; //where we just get a one there is no need for carry
        	b = carry;
        }       
        return a;
    }
}