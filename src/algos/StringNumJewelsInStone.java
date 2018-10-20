package algos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class StringNumJewelsInStone {

	public static void main(String[] args) {
		
	}
	
    public int numJewelsInStones(String J, String S) {
    	List<Character> jewels = IntStream.range(0, J.length()).mapToObj(i -> J.charAt(i)).collect(Collectors.toList());
        Set<Character> jSet = new HashSet<Character>(jewels);
        int c = 0;
        for (int k = 0; k < S.length(); k++) {
			if(jSet.contains(S.charAt(k))) {
				c++;
			}
		}        
        return c;       
    }

}