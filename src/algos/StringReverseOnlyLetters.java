package algos;

class StringReverseOnlyLetters {

	// https://leetcode.com/problems/reverse-only-letters/description/
	
	public static void main(String[] args) {
		System.out.println(new StringReverseOnlyLetters().reverseOnlyLetters("Test1ng-Leet=code-Q!"));
	}

    public String reverseOnlyLetters(String s) {
    	char[] sa = s.toCharArray();
    	int start = 0;
    	int end = s.length() - 1;
        while(start < end) {
			if(Character.isAlphabetic(sa[start])) {
				while(!Character.isAlphabetic(sa[end])) {
					end--;
				}
				char temp = sa[start];
				sa[start] = sa[end];
				sa[end] = temp;
				end--;
			}
			start++;
		}
        return new String(sa);
    }

}