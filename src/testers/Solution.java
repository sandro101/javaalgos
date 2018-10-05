package testers;

import java.util.Arrays;

public class Solution {

    static int nonDivisibleSubset(int k, int[] S) {
    	if(divisible(k, S, 0))
    		return S.length;
        for(int i = S.length; i > 0; i--){
            for(int j = 0; j <= i; j++){
                if(divisible(k, Arrays.copyOfRange(S, 0, i), S[j])){
                    return i - 1;
                }
            }                
        }
        return -1; // cannot be executed
    }
    
    static boolean divisible(int k, int[] S, int toExclude) {
        int sum = Arrays.stream(S).sum();
        return ((sum - toExclude) % k == 0); 
    }
}