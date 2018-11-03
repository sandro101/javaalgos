package algos;

import java.util.Arrays;
import java.util.stream.IntStream;

class ArrayPairSumMin {
	
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4 };
		System.out.println(new ArrayPairSumMin().arrayPairSum(nums));
	}

    public int arrayPairSum(int[] nums) {
    	Arrays.sort(nums);
    	return IntStream.iterate(0, x -> x + 2).limit(nums.length / 2).map(x -> nums[x]).sum();
    }

}