package algos;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class BitManipulationNumberWithPrimeBitsSet {
	
	//https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/description/
	
	public static void main(String[] args) {
		System.out.println(new BitManipulationNumberWithPrimeBitsSet().countPrimeSetBits(842, 888));
	}
   
    public int countPrimeSetBits(int l, int r) {    	
    	if(r < 2) return 0;
    	Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
    	int cPrimes = 0;
    	for (int i = l; i <= r; i++) {
        	int cOnes = 0;
            for (int j = i; j > 0; j/=2) {
            	cOnes += (j % 2 == 1) ? 1 : 0;
    		}
            cPrimes += (primes.contains(cOnes)) ? 1 : 0;            
		}
    	return cPrimes;
    }
    
}