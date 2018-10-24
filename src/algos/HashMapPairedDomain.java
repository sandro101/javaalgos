package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class HashMapPairedDomain {
	
	public static void main(String[] args) {
		String[] testStrArry = new String[] { "9001 discuss.leetcode.com", "9001 nob.leetcode.com" };
		System.out.println(new HashMapPairedDomain().subdomainVisits(testStrArry));
	}

    public List<String> subdomainVisits(String[] cpdomains) {
    	Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < cpdomains.length; i++) {
        	String[] cpSplit = cpdomains[i].split(" ");
        	int v = Integer.parseInt(cpSplit[0]);        	
        	String[] d = cpSplit[1].split("\\."); 
        	for (int j = 0; j < d.length; j++) {
        		String k = Arrays.stream(d).skip(d.length - j - 1).reduce((acc, x) -> acc + "." + x).get();
        		int tc = map.getOrDefault(k, 0);
        		map.put(k, tc + v);
			}   	
		}
        
        List<String> sol = new ArrayList<>();
        for (Entry<String, Integer> e : map.entrySet()) {
			sol.add(String.format("%s %s", e.getValue().toString(), e.getKey()));
		}        
        return sol;
    }
}