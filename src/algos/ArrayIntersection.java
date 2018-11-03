package algos;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class ArrayIntersection {

	//Array intersection using two sets
	
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> s1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
		s1.retainAll(Arrays.stream(nums2).boxed().collect(Collectors.toSet()));		
		return s1.stream().mapToInt(x -> x).toArray();
	}

}