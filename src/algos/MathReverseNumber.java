package algos;

class MathReverseNumber {
	
	public static void main(String[] args) {
		new MathReverseNumber().reverse(1534236469);		
	}
	
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if(Integer.MAX_VALUE / 10 < rev || (Integer.MAX_VALUE / 10 == rev && pop > 7)) return 0;
            if(Integer.MIN_VALUE / 10 > rev || (Integer.MIN_VALUE / 10 == rev && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

}