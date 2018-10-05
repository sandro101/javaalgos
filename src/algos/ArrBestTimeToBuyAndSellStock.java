package algos;

class ArrBestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
    	//Can be done better by storing the min value as you go along and then always using this to compare to with the value you are
    	//looking at and taking the delta between the two, if this delta is larger than the previous max delta store that max delta
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
}