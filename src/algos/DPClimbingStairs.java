package algos;

import java.util.HashMap;
import java.util.Map;

class DPClimbingStairs {
	static Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
	public static void main(String[] args) {
		System.out.println(climbStairs(25));
	}
	
    public static int climbStairs(int n) {
        if (n <= 2) {
        	cache.put(n, n);
        	return n;			
		}
    	if(cache.containsKey(n)) {
    		return cache.get(n);
    	}
        cache.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        return cache.get(n);
    }
    
    public int climbStairsDP(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}