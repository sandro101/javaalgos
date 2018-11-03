package algos;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ArraySimilarStrings {

	public static void main(String[] args) {
		String[] in = new String[] { "abc","acb","bac","bca","cab","cba" };
		System.out.println(new ArraySimilarStrings().numSpecialEquivGroups(in));
	}
	
	// by swapping only odd or even positioned strings with each other, determine which
	// strings can be remade from others in the array and return the actual number of unique strings
	
	// Soln is just to count the number of different letters in odd and even places in each string
	// If they are the same then with some swapping they can be made to look the same, do this for odd
	// and even placed strings

	public int numSpecialEquivGroups(String[] A) {
		Set<String> perms = new HashSet<>();
		for (String s : A) {
			int[] odds = new int[256];
			int[] evens = new int[256];
			for (int i = 0; i < s.length(); i++) {
				if (i % 2 == 0) {
					evens[s.charAt(i) - 'a']++;
				} else {
					odds[s.charAt(i) - 'a']++;
				}
			}
			perms.add(Arrays.toString(evens) + " " + Arrays.toString(odds));			
		}
		return perms.size();
	}

}