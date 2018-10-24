package algos;

class ArrTwoSumSorted {

    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left ++;
            } else {
                right --;
            }
        }        
        return null;
    }

}