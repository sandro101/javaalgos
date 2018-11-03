package algos;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayDistributeCandies {
	
	//Split candies between two people so they each get the same amount and try to maximise
	//the variety one person gets
	
    public int distributeCandies(int[] candies) {
        return Math.min(candies.length/2, Arrays.stream(candies).boxed().collect(Collectors.toSet()).size());    	
    }
};