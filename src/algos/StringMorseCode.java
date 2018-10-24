package algos;

import java.util.HashSet;
import java.util.Set;

class StringMorseCode {
	
	public static void main(String[] args) {
		String[] arr = new String[] { "gin", "zen", "gig", "msg" };
		new StringMorseCode().uniqueMorseRepresentations(arr);
	}
	
    public int uniqueMorseRepresentations(String[] words) {
    	String[] t = new String[] { ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.." };
    	Set<String> set = new HashSet<>();
    	for (int i = 0; i < words.length; i++) {
			set.add(words[i].chars().mapToObj(x -> t[x - 'a']).parallel().reduce((acc, x) -> acc + x).get());
		}
    	return set.size();
    }


}