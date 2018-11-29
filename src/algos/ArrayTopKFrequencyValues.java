package algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ArrayTopKFrequencyValues {

	// https://leetcode.com/problems/top-k-frequent-elements/description/
	
	public static void main(String[] args) {
		int[] testIntArry = new int[] { 1, 1, 1, 2, 2, 2, 3 };
		System.out.println(new ArrayTopKFrequencyValues().topKFrequent(testIntArry, 1));
	}
	
	// General approach is to create a freq map of how many times each number appears num -> freq
	// Then invert that map so we have a freq -> List of nums appearing that many times
	// Then loop over the inverted map copying the frequent elements up to whatever was asked for
	
	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		@SuppressWarnings("unchecked")
		List<Integer>[] buckets = new List[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
		}

		for (int key : freqMap.keySet()) {
			int freq = freqMap.get(key);
			if (buckets[freq] == null) {
				buckets[freq] = new ArrayList<Integer>();
			}
			buckets[freq].add(key);
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = buckets.length - 1; i >= 0 && list.size() < k; i--) {
			if (buckets[i] != null) {
				list.addAll(buckets[i]);
			}
		}
		return list;
	}

}