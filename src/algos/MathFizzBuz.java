package algos;

import java.util.ArrayList;
import java.util.List;

public class MathFizzBuz {

	public List<String> fizzBuzz(int n) {
		List<String> sol = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
        	String s = "";
        	if(i % 3 == 0 || i % 5 == 0) {
    			if(i % 3 == 0) {
    				s += "Fizz";
    			}
    			if(i % 5 == 0) {
    				s += "Buzz";
    			}
        	} else {
        		s = String.valueOf(i);
        	}
			sol.add(s);			
		}
        return sol;
    }

};