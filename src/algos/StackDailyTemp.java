package algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class StackDailyTemp {

	// https://leetcode.com/problems/daily-temperatures/description/

	public static void main(String[] args) {
		int[] t = new int[] { 34, 80, 80, 34, 34, 80, 80, 80, 80, 34 };
		System.out.println(new StackDailyTemp().dailyTemperatures(t));
	}

	public int[] dailyTemperatures(int[] t) {
		Stack<Integer> st = new Stack<Integer>();
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		int[] sol = new int[t.length];
		for (int i = 0; i < t.length; i++) {
			while (!st.isEmpty() && st.peek() < t[i]) {
				List<Integer> days = map.get(st.pop());
				for (int j = 0; j < days.size(); j++) {
					sol[days.get(j)] = i - days.get(j);
					days.remove(j);
				}
			}
			st.push(t[i]);
			List<Integer> days = map.getOrDefault(t[i], new ArrayList<Integer>());
			days.add(i);
			map.put(t[i], days);
		}
		return sol;
	}

}