package algos;

class DPNumArray {
	int[] cum;
    public DPNumArray(int[] nums) {
        if(nums.length != 0) {
            this.cum = new int[nums.length];
    	    this.cum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
        	    this.cum[i] = this.cum[i-1] + nums[i];
		    }  
        } else {
            this.cum = new int[nums.length];
        }

    }
    
    public int sumRange(int i, int j) {
        return this.cum[j] - ((i > 0) ? this.cum[i - 1] : 0);
    }

}