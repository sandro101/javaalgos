package algos;

import java.util.HashSet;
import java.util.Set;

class StringLongestSubstringWithoutRepeatingCharacters {

	// 3 leetcode
	public int lengthOfLongestSubstring(String s) {
		int length = 0;
		for (int i = 0; i < s.length(); i++) {
			Set<Character> set = new HashSet<>();
			int l = 0;
			for (int j = i; j < s.length(); j++) {
				char c = s.charAt(j);
				if (set.contains(c)) {
					break;
				} else {
					set.add(c);
					l++;
					length = Math.max(length, l);
				}
			}
		}
		return length;
	}

	// sliding window
	public int lengthOfLongestSubstring2(String s) {
		int length = 0;
		Set<Character> set = new HashSet<>();
		int i = 0;
		int j = 0;
		int l = 0;
		while (i < s.length() && i <= j && j < s.length()) {
			char c = s.charAt(j);
			if (!set.contains(c)) {
				l++;
				length = Math.max(length, l);
				set.add(c);
				j++;
			} else {
				set.remove(s.charAt(i));
				l--;
				i++;
			}
		}
		return length;
	}

}