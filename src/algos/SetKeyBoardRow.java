package algos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SetKeyBoardRow {
	
	public static void main(String[] args) {
		String[] words = new String[] { "Hello","Alaska","Dad","Peace" };
		System.out.println(new SetKeyBoardRow().findWords(words));
	}

    public String[] findWords(String[] words) {
    	
        Set<Character> row1 = new HashSet<>();
        Set<Character> row2 = new HashSet<>();
        Set<Character> row3 = new HashSet<>();
        Set<Character> alphabet = new HashSet<>();
        
        alphabet.add('a');
        alphabet.add('l');
        alphabet.add('p');
        alphabet.add('h');
        alphabet.add('b');
        alphabet.add('e');
        alphabet.add('t');
        
        row1.add('q');
        row1.add('w');
        row1.add('e');
        row1.add('r');
        row1.add('t');
        row1.add('y');
        row1.add('u');
        row1.add('i');
        row1.add('o');
        row1.add('p');
        
        row2.add('a');
        row2.add('s');
        row2.add('d');
        row2.add('f');
        row2.add('g');
        row2.add('h');
        row2.add('j');
        row2.add('k');
        row2.add('l');
        
        row3.add('z');
        row3.add('x');
        row3.add('c');
        row3.add('v');
        row3.add('b');
        row3.add('n');
        row3.add('m');
                
        List<String> res = new ArrayList<>();
        Set<Character> wtc = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
			char[] word = words[i].toLowerCase().toCharArray();
			wtc.addAll(IntStream.range(0, word.length).mapToObj(x-> word[x]).collect(Collectors.toList()));
			Set<Character> set1 = new HashSet<Character>(wtc);
			set1.retainAll(row1);

			Set<Character> set2 = new HashSet<Character>(wtc);
			set2.retainAll(row2);
			
			Set<Character> set3 = new HashSet<Character>(wtc);
			set3.retainAll(row3);
			
			if(wtc.equals(set1) || wtc.equals(set2) || wtc.equals(set3)) {
				res.add(words[i]);
			}
			
			wtc.clear();
		}        
        return res.toArray(new String[res.size()]);
    }

}