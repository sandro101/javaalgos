package algos;

import java.util.Stack;

class StackBaseballGamePoints {

	public static void main(String[] args) {
		String[] ops = new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" };
		System.out.println(new StackBaseballGamePoints().calPoints(ops));
	}

	public int calPoints(String[] ops) {
		Stack<Integer> scores = new Stack<>();
		for (String s : ops) {
			switch (s) {
			case "+":
				sumPrevScores(scores);
				break;
			case "D":
				scores.push(scores.peek() * 2);
				break;
			case "C":
				scores.pop();
				break;
			default:
				scores.push(Integer.parseInt(s));
			}
		}
		return scores.stream().mapToInt(x -> x).sum();
	}

	private void sumPrevScores(Stack<Integer> scores) {
		int pp = scores.pop();
		int p = scores.peek();
		scores.push(pp);
		scores.push(pp + p);
	}
}