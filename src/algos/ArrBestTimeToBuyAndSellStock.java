package algos;

class ArrBestTimeToBuyAndSellStock {

	//O(N2)
    public int maxProfit(int[] prices) {
    
    	int max = 0;
    	for(int i = 0; i < prices.length - 1; i++) {
    		int j = i + 1;
    		while(j < prices.length) {
        		if(max < prices[j] - prices[i]) {
        			max = prices[j] - prices[i];
        		}
        		j++;
    		}

    	}    	
    	return max;
    }
    //Can be done better by storing the min value as you go along and then always using this to compare to with the value you are
	//looking at and taking the delta between the two, if this delta is larger than the previous max delta store that max delta
    //O(N)
    public int maxProfitBetter(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        // The way this is structures ensures we are only comparing minimums with values that come
        // after it in the list of prices
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}