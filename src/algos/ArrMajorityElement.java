package algos;

import java.util.Arrays;
import java.util.stream.Collectors;

class ArrMajorityElement {

    public int majorityElement(int[] nums) {
    	return Arrays
    	.stream(nums)
    	.boxed()
    	.collect(Collectors.groupingBy(x->x, Collectors.counting()))
    	.entrySet()
    	.stream()
    	.sorted((e, k) -> e.getValue().intValue() - k.getValue().intValue())
    	.findFirst()
    	.map(e -> e.getKey())
    	.get();
    }
    
    //Another possibly interesting solution to this would be to choose an element at random
    //and then check if it is the majority element, technically O(infinity) but likely O(N)
    
    //Also could sort and then just take the n/2 element
}