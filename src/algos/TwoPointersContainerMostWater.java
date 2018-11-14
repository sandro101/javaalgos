package algos;

// 11 on leet code

class TwoPointersContainerMostWater {

	// brute force, slow
    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    } 
    // two pointer, much faster
    public int maxArea2(int[] h) {
        int max = 0;
        int i = 0;
        int j = h.length - 1;
        while(i >= 0 && j < h.length && i < j) {                        
            if(h[i] > h[j]) {
                max = Math.max(max, (j - i) * h[j]);
                j--;
            } else {
                max = Math.max(max, (j - i) * h[i]);
                i++;
            }
        }
        return max;
    } 
}