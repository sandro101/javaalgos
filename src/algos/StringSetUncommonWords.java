package algos;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StringSetUncommonWords {

	// check for words which don't appear in both sentences
    public String[] uncommonFromSentences2(String A, String B) {
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        Set<String> sa = buildSentenceSet(a);
        Set<String> sb = buildSentenceSet(b);        
        sa = findUncommonWords(a, b, sa, sb);
        return sa.toArray(new String[sa.size()]);
    }

	private Set<String> findUncommonWords(String[] a, String[] b, Set<String> sa, Set<String> sb) {
		sa.removeAll(Arrays.asList(b));
        sb.removeAll(Arrays.asList(a));
        sa.addAll(sb);
        return sa;
	}

	private Set<String> buildSentenceSet(String[] a) {
		Map<String, Long> words = Arrays.stream(a).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		Set<String> sa = words.entrySet().stream()
			.filter(e-> e.getValue() < 2)
			.map(e -> e.getKey())
			.collect(Collectors.toSet());
		return sa;
	}
	
    public String[] uncommonFromSentences(String A, String B) {
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        Set<String> sa = buildSentenceSet(a);
        Set<String> sb = buildSentenceSet(b);        
        sa = findUncommonWords(a, b, sa, sb);
        return sa.toArray(new String[sa.size()]);
    }
};