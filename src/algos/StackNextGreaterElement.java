package algos;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class StackNextGreaterElement {
	
	//https://leetcode.com/problems/next-greater-element-i/description/
	
	public static void main(String[] args) {
		int[] nums1 = new int[] { 2, 4 };
		int[] nums2 = new int[] { 1, 2, 3, 4 };
		System.out.println(new StackNextGreaterElement().nextGreaterElement(nums1, nums2));
	}
	
	//Very clever solution using a Stack to record all the numbers smaller than the next number
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    	Stack<Integer> st = new Stack<>();
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int[] sol = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
        	while(!st.isEmpty() && st.peek() < nums2[i]) {
        		map.put(st.pop(), nums2[i]);
        	}
        	st.push(nums2[i]);        	
		}
        for (int i = 0; i < nums1.length; i++) {
			sol[i] = map.getOrDefault(nums1[i], -1);
		}
        return sol;
    }
}