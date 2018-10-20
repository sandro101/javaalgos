package algos;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class MathHappyNumber {
	
	public static void main(String[] args) {
		System.out.println(new MathHappyNumber().isHappy(3454543));
	}

    public boolean isHappy(int n) {
    	Set<Integer> visited = new HashSet<>();
        if(performHappyCalc(n, visited) == -1) {
        	return false;
        } else {
        	return true;
        }
    }

	private int performHappyCalc(int n, Set<Integer> visited) {
		if(visited.contains(n)) return -1;
		visited.add(n);
		if(n == 1) return 1;
		String[] radix = Integer.toString(n).split("");
		return performHappyCalc(
			Arrays
			.stream(radix)
			.map(x -> Integer.parseInt(x) * Integer.parseInt(x))
			.reduce((acc, x) -> x + acc).get(),
			visited
		);
		
	}

}