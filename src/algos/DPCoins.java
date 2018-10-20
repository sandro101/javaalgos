package algos;

import java.util.Arrays;

class DPCoins {
	
	public static void main(String[] args) {
		int[] testIntArry = new int[] { 1, 3, 5 };
		int value = 6;
		System.out.println(coinChange(testIntArry, value));
	}
	
    public static int coinChange(int[] coins, int amount) {
    	if(amount == 0) {
    		return 0;
    	}
    	long[] cacheOfCoinsNeededForEachValue = new long[amount + 1];    	
    	Arrays.fill(cacheOfCoinsNeededForEachValue, Integer.MAX_VALUE);
    	cacheOfCoinsNeededForEachValue[0] = 0;
    	//for each amount check which coin is best to use by trying all of them
    	//dont try coins which are bigger than the amount being tested
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                	cacheOfCoinsNeededForEachValue[i] = Math.min(cacheOfCoinsNeededForEachValue[i], cacheOfCoinsNeededForEachValue[i - coins[j]] + 1);
                }
            }
        }  	
    	return (int) ((cacheOfCoinsNeededForEachValue[amount] == Integer.MAX_VALUE) ? -1 : cacheOfCoinsNeededForEachValue[amount]);
    }

}	