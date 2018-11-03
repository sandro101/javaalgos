package algos;

import java.util.Arrays;

class ArrayRemoveElementInPlace {

	public static void main(String[] args) {
		// int[] nums = new int[] { 3, 2, 2, 3 };
		int[] nums = new int[] { 0, 1, 2, 2, 3, 0, 4, 2 };
		int length = new ArrayRemoveElementInPlace().removeElement(nums, 2);
		System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, length)));
	}

	// My really shit solution
	public int removeElement(int[] nums, int val) {
		int j = nums.length - 1;
		int k = nums.length - 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {
				j = k;
				while (j > i) {
					if (nums[j] != val) {
						nums[i] = nums[j];
						nums[j] = val;
						k = j - 1;
						break;
					}
					j--;
				}
			}
		}
		return nums.length - (int) Arrays.stream(nums).boxed().filter(x -> x.equals(val)).count();
	}

	// A much much better way
	public int removeElementBetter(int[] nums, int val) {
		//Basically for every number in the array just place it at the ith position
		//where the ith position is the position of the number if there were no "val"s in it
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}

}