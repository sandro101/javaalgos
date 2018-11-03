package algos;

class BitMissingLetter {
	
	public static void main(String[] args) {
		System.out.println(findTheDifference("acbd", "abcde"));
	}
	
	// find the letter missing between two strings
	// soln works on the principle that when you XOR something with its self you get nothing
	// In this specific ecample, we knew t was longer than s
	
    public static char findTheDifference(String s, String t) {
    	if (s.length() == 0) {
			return t.charAt(0);
		}
    	
    	int missing = (int) t.charAt(0);
    	
    	for (int i = 1; i < t.length(); i++) {
			missing ^= t.charAt(i) ^ s.charAt(i-1);
		}
    	
    	return (char) missing;
        
    }
}