package algos;

class ArrProductExceptSelf {
	public static void main(String[] args) {
		productExceptSelf(new int[] {1, 2, 3, 4, 5});
	}

	public static int[] productExceptSelf(int[] nums) 
    {
        int[] result = new int[nums.length];
        int productOfLeftNumbers = 1;
        //For and array [a, b, c] this give -> [1, a, a.b]        
        for(int i = 0; i < nums.length; i++)
        {
            result[i] = productOfLeftNumbers;
            productOfLeftNumbers = productOfLeftNumbers * nums[i];
        }
        int productOfRightNumbers = 1;
        //Applying the same logic running over the array backwards -> [1.c.b, a.c, a.b]
        for(int i = nums.length - 1; i >= 0; i--)
        {
            result[i] = result[i] * productOfRightNumbers;
            productOfRightNumbers = productOfRightNumbers * nums[i];
        }
        return result;
    }
}