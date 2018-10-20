	package algos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

class StackGenerateBrackets {
	
	public static void main(String[] args) {
		new StackGenerateBrackets().generateParenthesis(3);
	}
	
    public List<String> generateParenthesis(int n) {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < n; i++) {
			sb.append("()");
		}
    	String brackets = sb.toString();
    	Set<String> sol = new HashSet<String>();
    	backtrack(brackets, n * 2, new StringBuilder(), sol, 0);
    	List<String> list = new ArrayList<>();
    	list.addAll(sol);
    	return list;
    }
    

	private void backtrack(String brackets, int length, StringBuilder sb, Set<String> permutations, int start) {
		if(!permutations.contains(sb.toString()) && length == sb.length() && isValid(sb.toString())) {			
			permutations.add(sb.toString());
		}
		for (int i = start; i < brackets.length(); i++) {
			sb.append(brackets.charAt(i));
			backtrack(brackets, length, sb, permutations, start + 1);
			sb.delete(sb.length() - 1, sb.length());
		}		
	} 
	
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
			char b = s.charAt(i);
			if(b == '(') brackets.push(b);			
			if(b == ')' && (brackets.isEmpty() ||  brackets.pop() != '(')) return false;	
		}
        return brackets.isEmpty();
    }
}