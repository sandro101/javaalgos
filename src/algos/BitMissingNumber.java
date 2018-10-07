package algos;

class BitMissingNumber {
	public static void main(String[] args) {
		int[] testIntArry = new int[] { 0, 1, 3 };
		System.out.println(missingNumber(testIntArry));
	}
    public static int missingNumber(int[] nums) {
    	int runningTotal = 0 ^ nums[0];
        for (int i = 1; i < nums.length; i++) {
        	runningTotal ^= nums[i] ^ i;  
		}
        return runningTotal ^ nums.length;
    }
}