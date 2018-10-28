package algos;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ArraySimilarStrings {

	public static void main(String[] args) {
		String[] in = new String[] { "abc","acb","bac","bca","cab","cba" };
		System.out.println(new ArraySimilarStrings().numSpecialEquivGroups(in));
	}

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