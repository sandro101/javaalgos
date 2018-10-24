package algos;

import java.util.Arrays;

class StringReverseWordsKeepOrderInSentence {

    public String reverseWords(String s) {
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
			split[i] = new StringBuilder(split[i]).reverse().toString();
		}
        String sol = Arrays.stream(split).reduce((acc, x)-> acc + " " + x).get();
		sol.trim();
		return sol;
    }
}