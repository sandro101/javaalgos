package algos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class StringReverseWords {

	// https://leetcode.com/problems/reverse-words-in-a-string/description
	
	public static void main(String[] args) {
		String res = new StringReverseWords().reverseWords("     a little  fox  jumped     up ");
		System.out.println("[" + res + "]");
	}
	
    public String reverseWords(String s) {        
        while(s.contains("  ")) {
        	s = s.replaceAll("  ", " ");
        } 
        if(s.startsWith(" ")) {
        	s = s.substring(1);
        }
        if(s.endsWith(" ")) {
        	s = s.substring(0, s.length() - 1);
        }
        List<String> words = Arrays.asList(s.split(" "));
        Collections.reverse(words);
        return words.stream().reduce((acc, w) -> acc + " " + w).get();
    }
}