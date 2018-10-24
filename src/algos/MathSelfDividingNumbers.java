package algos;

import java.util.ArrayList;
import java.util.List;

class MathSelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
    	List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
        	boolean flag = true;
        	int num = i;
			while(num > 0 && flag) {
				int divisor = num % 10;
				if(divisor == 0 || i % divisor != 0) {
					flag = false;
					break;
				}
				num = num / 10;
			}
			if(flag) {
				ans.add(i);
			}
		}
        return ans;
    }

}