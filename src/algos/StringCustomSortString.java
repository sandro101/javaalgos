package algos;

import java.util.Map;
import java.util.stream.Collectors;

public class StringCustomSortString {
	
	// https://leetcode.com/problems/custom-sort-string/description/
	
	public static void main(String[] args) {
		System.out.println(new StringCustomSortString().customSortString("cba","abcdfwwwa"));
	}

    public String customSortString(String s, String t) {
    	char[] sol = new char[t.length()];
    	Map<Character, Long> chars = t.chars()
    		.mapToObj(i->(char)i)
    		.collect(Collectors.groupingBy(x->x, Collectors.counting()));
        int k = 0;
        k = constructNewString(s, sol, chars, k);
        constructNewString(t, sol, chars, k);
        return new String(sol);
    }

	private int constructNewString(String s, char[] sol, Map<Character, Long> chars, int k) {
		for (int i = 0; i < s.length(); i++) {
        	if(chars.containsKey(s.charAt(i))) {
        		long c = chars.get(s.charAt(i));
        		chars.remove(s.charAt(i));
        		while(c > 0) {
        			sol[k] = s.charAt(i);
        			k++;
        			c--;
        		}
        	}
		}
		return k;
	}
};