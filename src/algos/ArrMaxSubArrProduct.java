	package algos;

class ArrMaxSubArrProduct {
	public static void main(String[] args) {
		int[] testIntArry = new int[] { 2, 3, -2, 4 };
		System.out.println(maxProduct(testIntArry));
			
	}

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
    	int max = nums[0];
    	int min = nums[0];
    	int result = max;
    	for (int i = 1; i < nums.length; i++) {
    		int curr = nums[i];
    		int tempMin = min;
    		min = Math.min(max * curr, Math.min(curr, min * curr));
    		max = Math.max(max * curr, Math.max(curr, tempMin * curr));
    		if (max > result) {
				result = max;
			}
			
		}
    	return result;
    }
}

