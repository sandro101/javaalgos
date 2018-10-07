package algos;

class BitMissingLetter {
	
	public static void main(String[] args) {
		System.out.println(findTheDifference("abcd", "abcde"));
	}
	
    public static char findTheDifference(String s, String t) {
    	if (s.length() == 0) {
			return t.charAt(0);
		}
    	
    	int missing = (char) t.charAt(0);
    	
    	for (int i = 1; i < t.length(); i++) {
			missing ^= ((int) t.charAt(i)) ^ ((int) s.charAt(i-1));
		}
    	
    	return (char) missing;
        
    }
}