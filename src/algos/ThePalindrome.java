package algos;

public class ThePalindrome {
	public int find(String s){		
		if(isPalindrome(s)) {
			return s.length();
		} else {
			return 2 + find(s.substring(1));
		}
	}

	private boolean isPalindrome(String s) {
		return s.equals(new StringBuilder(s).reverse().toString()	);
	}
}
