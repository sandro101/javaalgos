package algos;

class StringLongestPalindrome {

	// 5 leetcode
	
	// too slow brute force
	public String longestPalindrome(String s) {
		if (s.length() < 2)
			return s;
		int maxL = 0;
		int bi = 0;
		int bj = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if (isPalindrome(s.substring(i, j + 1))) {
					if (j - i + 1 >= maxL) {
						bi = i;
						bj = j;
						maxL = j - i + 1;
					}
				}
			}
		}
		return s.substring(bi, bj + 1);
	}

	private boolean isPalindrome(String s) {
		char[] word = s.toCharArray();
		int i1 = 0;
		int i2 = word.length - 1;
		while (i2 > i1) {
			if (word[i1] != word[i2]) {
				return false;
			}
			++i1;
			--i2;
		}
		return true;
	}

	// expand around centre
	public String longestPalindrome2(String s) {
		if (s == null || s.length() < 1)
			return "";
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return r - l - 1;
	}
}