package algos;

import java.util.Arrays;

class ArrayColourSort {
	
	public static void main(String[] args) {
		int[] testIntArry = new int[] { 0, 2, 1, 1, 2, 0 };
		new ArrayColourSort().sortColors(testIntArry);
		System.out.println(Arrays.toString(testIntArry));
	}

    public void sortColors(int[] nums) {
    	int[] arr = new int[3];
        for (int i = 0; i < nums.length; i++) {
			arr[nums[i]]++;
		}
    	int k = 0;
        for (int i = 0; i < arr.length; i++) {
        	int j = 0;
			for (; j < arr[i]; j++) {
				nums[k] = i;
				k++;
			}
		}
    }

}