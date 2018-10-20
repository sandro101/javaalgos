package algos;

import java.util.Stack;

class StackBalancedBrackets {
	
	public static void main(String[] args) {
		System.out.println(new StackBalancedBrackets().isValid("()[]{}"));
	}
	
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
			char b = s.charAt(i);
			if(b == '[') brackets.push(b);
			if(b == '(') brackets.push(b);
			if(b == '{') brackets.push(b);
			if(b == ']' && (brackets.isEmpty() ||  brackets.pop() != '[')) return false;
			if(b == ')' && (brackets.isEmpty() ||  brackets.pop() != '(')) return false;	
			if(b == '}' && (brackets.isEmpty() ||  brackets.pop() != '{')) return false;
		}
        return brackets.isEmpty();
    }
    
}