package algos;

class StringLongestCommonPrefix {
	
	public static void main(String[] args) {
		String[] testStrArry = new String[] { "", "" };
		System.out.println("[" + new StringLongestCommonPrefix().longestCommonPrefix(testStrArry) + "]");
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		int k = 0;
		while (k < strs[0].length()) {
			char c = strs[0].charAt(k);
			for (int i = 1; i < strs.length; i++) {
				if (strs[i].length() > k && strs[i].charAt(k) == c) {
					continue;
				} else {
					return strs[0].substring(0, k);
				}
			}
			k++;
		}
		return strs[0];
	}
	
	//Another more advanced and possibly faster approach to this is to binary search the strings taking from
	//0 -> mid and checking if that is the start of each string, if it isn'xt then split that in half and so on
	//and so forth. Obviously to employ this technique you first need to know the length of the shortest string
	//as this is what you will need to base your search off of.

}