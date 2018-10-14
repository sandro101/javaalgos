package algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ArrayTopKFrequencyValues {

	public static void main(String[] args) {
		int[] testIntArry = new int[] { 1, 1, 1, 2, 2, 3 };
		new ArrayTopKFrequencyValues().topKFrequent(testIntArry, 2);
	}

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