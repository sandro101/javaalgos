package algos;

import java.util.HashMap;
import java.util.Map;

public class FibonacciDiv2 {

	Map<Integer, Integer> fibNums = new HashMap<Integer, Integer>();
	
	public FibonacciDiv2() {
		fibNums.put(1, 1);
		fibNums.put(2, 1);
		fib(100);
	}
	
	public int find(int start) {
		int min = Integer.MAX_VALUE;
		for(Integer val: fibNums.values()) {
			int candidate = Math.abs(val - start);
			if(candidate <= min) {
				min = candidate;
			} else {
				return min;
			}
		}
		throw new RuntimeException();
	}

	private int fib(int val) {
		if (fibNums.containsKey(val)) {
			return fibNums.get(val);
		} else {
			fibNums.put(val - 1, fib(val - 1));
			fibNums.put(val - 2, fib(val - 2));
			return fib(val - 1) + fib(val - 2);
		}
	}

}
