package algos;

import java.util.HashMap;
import java.util.Map;

class StringRomanToInt {
	
    public int romanToInt(String s) {
        Map<Character, Integer> mapping = new HashMap<Character, Integer>();
        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);
        
        if(s.length() == 0) {
        	return 0;
        }
        
        if(s.length() == 1) {
        	mapping.get(s.charAt(0));
        }
        int total = 0;
        for (int i = 0; i < s.length() - 1; i++) {
        	Character c1 = s.charAt(i);
        	Character c2 = s.charAt(i + 1);
        	int v1 = mapping.get(c1);
        	int v2 = mapping.get(c2);
        	if(v2 > v1) {
        		total -= v1;
        	} else {
        		total += v1;
        	}
		}
        total += mapping.get(s.charAt(s.length() - 1));
        return total;
    }


}