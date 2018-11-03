package algos;

import java.util.Arrays;

public class StringGoatLatin {
	
	public static void main(String[] args) {
		System.out.println(new StringGoatLatin().toGoatLatin("Each"));
	}

    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        String[] sol = new String[words.length];
        for (int i = 0; i < words.length; i++) {
			String w = words[i];
			if(String.valueOf(w.charAt(0)).matches("[aeiouAEIOU]")) {
				w = w.concat("ma");
			} else {
				char c = w.charAt(0);				
				w = w.substring(1);
				w = w.concat(String.valueOf(c).concat("ma"));				
			}
			for (int j = 0; j <= i; j++) {
				w = w.concat("a");
			}
			sol[i] = w.concat((i < words.length - 1) ? " " : "");
		}
        return Arrays.stream(sol).reduce(String::concat).get();
    }
};