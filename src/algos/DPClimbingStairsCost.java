package algos;

import java.util.HashMap;
import java.util.Map;

class DPClimbingStairsCost {

	public static void main(String[] args) {
		int[] testIntArry = new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		System.out.println(new DPClimbingStairsCost().minCostClimbingStairs(testIntArry));
	}
	//Probably dont need the defaults, they will already be filled in for preior iterations.
	public int minCostClimbingStairs(int[] cost) {
		Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
		cache.put(0, cost[0]);
		cache.put(1, cost[1]);

		for (int i = 2; i < cost.length; i++) {
			int cMin = cache.getOrDefault(i, Integer.MAX_VALUE);
			int min1sb = cache.get(i - 1) + cost[i];
			int min2sb = cache.get(i - 2) + cost[i];
			cache.put(i, Math.min(cMin, Math.min(min1sb, min2sb)));
		}
		return Math.min(cache.get(cost.length - 1), cache.get(cost.length - 2));
	}

}