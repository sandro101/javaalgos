package algos;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayDistributeCandies {
    public int distributeCandies(int[] candies) {
        return Math.min(candies.length/2, Arrays.stream(candies).boxed().collect(Collectors.toSet()).size());    	
    }
};