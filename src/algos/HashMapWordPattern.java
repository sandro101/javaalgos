package algos;

import java.util.HashMap;
import java.util.Map;

class HashMapWordPattern {

	// https://leetcode.com/problems/word-pattern/description/
	
	public static void main(String[] args) {		
		System.out.println(new HashMapWordPattern().wordPattern("abbac", "cat cat cat cat fish"));
	}
	
    public boolean wordPattern(String pattern, String str) {
    	String[] words = str.split(" ");
    	if(words.length != pattern.length()) return false;
    	Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
        	map.putIfAbsent(pattern.charAt(i), words[i]);
        	if(!map.get(pattern.charAt(i)).equals(words[i])) return false;
		}	
        return map.values().stream().distinct().count() == map.size();
    }
}	