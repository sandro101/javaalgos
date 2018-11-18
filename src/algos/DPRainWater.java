package algos;

class DPRainWater {

	// 42 leet code
	// DP Solution
	public int trap(int[] h) {
		if (h.length < 3)
			return 0;
		int capture = 0;

		// keep track of the tallest height at or to the left of i
		int[] maxLeftHeight = new int[h.length];
		maxLeftHeight[0] = h[0];
		for (int i = 1; i < h.length; i++) {
			maxLeftHeight[i] = Math.max(maxLeftHeight[i - 1], h[i]);
		}

		// keep track of the tallest height at or to the right of i
		int[] maxRightHeight = new int[h.length];
		maxRightHeight[h.length - 1] = h[h.length - 1];
		for (int i = h.length - 2; i >= 0; i--) {
			maxRightHeight[i] = Math.max(maxRightHeight[i + 1], h[i]);
		}

		// Now we have for any i what the maximum heights either side are
		for (int i = 0; i < h.length; i++) {
			// we cant capture up to a level higher than the minimum height on either the
			// left or right
			// we cant capture more than the depth of the 'valley' so we have to remove its
			// height
			// l = 10, r = 8
			// min(l, r) = 8
			// h[i] = 7 (height of the valley)
			// we can only capture 8 - 7 = 1 (depth of valley)
			capture += Math.min(maxLeftHeight[i], maxRightHeight[i]) - h[i];
		}
		return capture;
	}

	// Two pointers
	public int trap2(int[] h) {
	        if(h.length < 3) return 0;
	        int l = 0;
	        int r = h.length - 1;
	        int contained = 0;
	        while(l < r) {
	            if(h[l] > h[r]) {
	                int rightHeight = h[r];
	                while(l < r && h[r] <= rightHeight) {                     
	                    contained += rightHeight - h[r];
	                    r--;
	                }
	            } else { 
	                int leftHeight = h[l];
	                while(l < r && h[l] <= leftHeight) {                     
	                    contained += leftHeight - h[l]; 
	                    l++; 
	                }
	            }
	        }
	        return contained;
	}
}