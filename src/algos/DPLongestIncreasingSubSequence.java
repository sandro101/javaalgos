package algos;

class DPLongestIncreasingSubSequence {

	public static void main(String[] args) {
		int[] testIntArry = new int[] { 4, 10, 4, 3, 8, 9 };
		System.out.println(lengthOfLIS(testIntArry));
	}

	public static int lengthOfLIS(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int[] cacheContainingMaxLengthSubSeqForEachSizeArray = new int[nums.length];
        cacheContainingMaxLengthSubSeqForEachSizeArray[0] = 1;
        int maxSubSequenceOverAll = 1;
        for (int i = 1; i < nums.length; i++) { 
        	int maxFromThisRoundOfChecks = 0;
			for (int j = 0; j < i; j++) {	
				if(nums[i] > nums[j]) { 
					maxFromThisRoundOfChecks = Math.max(cacheContainingMaxLengthSubSeqForEachSizeArray[j], maxFromThisRoundOfChecks);			
				}		
			}
			cacheContainingMaxLengthSubSeqForEachSizeArray[i] = maxFromThisRoundOfChecks + 1;
			maxSubSequenceOverAll = Math.max(maxSubSequenceOverAll, cacheContainingMaxLengthSubSeqForEachSizeArray[i]);			
		}        
        return maxSubSequenceOverAll;
	}

}