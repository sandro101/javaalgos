package algos;

class StringNumberOfLinesToWrite {

    public int[] numberOfLines(int[] widths, String S) {
    	int l = 0;
    	int r = 0;
        for (int i = 0; i < S.length(); i++) {
			if(l%100 + widths[S.charAt(i) - 'a'] > 100) {
				l = widths[S.charAt(i) - 'a'];
				r++;				
			} else {
				l += widths[S.charAt(i) - 'a'];		
			}
		}
        return new int[] { l, r };
    }

}