package algos;

import java.util.Arrays;

class StringPointersHowFarFromCharacter {
	
	public static void main(String[] args) {
		System.out.println( new StringPointersHowFarFromCharacter().shortestToChar("aaba", 'b'));
	}

	public int[] shortestToChar(String s, char c) {
		int[] res = new int[s.length()];
		Arrays.fill(res, Integer.MAX_VALUE);
		Integer pc = null;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				if(pc != null) {
					for (int j = pc; j <= i; j++) {
						res[j] = Math.min(j - pc, i - j);
					}
				} else {
					for (int j = 0; j <= i; j++) {
						res[j] = i - j;
					}
				}
				pc = i;
			}
		}
		if(pc != s.length() - 1) {
			for (int i = pc; i < s.length(); i++) {
				res[i] = i - pc;
			}
		}
		return res;
	}
}