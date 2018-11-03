package algos;

import java.util.Stack;

class StackBracketMultiplication {
	
	// https:leetcode.com/problems/score-of-parentheses/description/
	
	public static void main(String[] args) {
		System.out.println(new StackBracketMultiplication().scoreOfParentheses("((()()((()))))"));
	}
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        for(char c: s.toCharArray()) {
        	if(c == '(') {
        		stack.push(0);
        	} else {
        		int iSum = 0;
        		while(!stack.isEmpty() && stack.peek() != 0) {
        			iSum += stack.pop();
        		}
        		stack.pop();
        		stack.push(Math.max(1, iSum * 2));
        	}
        }
        return stack.stream().mapToInt(x->x).sum();
    }    
}