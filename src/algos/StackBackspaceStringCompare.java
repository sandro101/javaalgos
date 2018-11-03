package algos;

import java.util.Stack;

class StackBackspaceStringCompare {
	
	//https://leetcode.com/problems/backspace-string-compare/description/
	
	public static void main(String[] args) {	
		System.out.println(new StackBackspaceStringCompare().backspaceCompare("y#fo##f", "y#f#o##f"));
	}
	
    public boolean backspaceCompare(String s, String t) {
        return typeString(s).equals(typeString(t));
    }

	private Stack<Character> typeString(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '#' && !stack.isEmpty()) {
				stack.pop();
			} else {
				if(s.charAt(i) != '#') {
					stack.push(s.charAt(i));
				}				
			}
		}
		return stack;
	}
}