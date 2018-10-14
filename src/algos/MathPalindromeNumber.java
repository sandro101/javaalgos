package algos;

class MathPalindromeNumber {
	
	public static void main(String[] args) {
		System.out.println(new MathPalindromeNumber().isPalindrome(121));		
	}
	
    public boolean isPalindrome(int x) {
    	if(x < 0) return false;
    	int size = (int) Math.log10(x);
    	while(x > 0) {
			int last = x % 10;
			int first = (int) (x / Math.pow(10, size));
			if(first - last != 0) return false;
			x = (int) (x % Math.pow(10, size));
			x = x / 10;
			size -= 2;
		}
    	return true;
    }

}