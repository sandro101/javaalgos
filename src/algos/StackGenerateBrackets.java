package algos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

class StackGenerateBrackets {

	public static void main(String[] args) {
		System.out.println(new StackGenerateBrackets().generateParenthesis(3));
	
	}

	public List<String> generateParenthesis(int n) {
		Set<String> sol = new HashSet<String>();
		permute("", n * 2, sol, n * 2);
		List<String> list = new ArrayList<>();
		list.addAll(sol);
		return list;
	}

	private void permute(String s, int size, Set<String> sol, int n) {
		if (s.length() == n) {
			if(isValid(s)) sol.add(s);			
		} else {
			permute("(" + s, size - 1, sol, n);
			permute(")" + s, size - 1, sol, n);
		}
	}

	public boolean isValid(String s) {
		Stack<Character> brackets = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char b = s.charAt(i);
			if (b == '(')
				brackets.push(b);
			if (b == ')' && (brackets.isEmpty() || brackets.pop() != '('))
				return false;
		}
		return brackets.isEmpty();
	}
}