package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RecursionBacktrackingPermuationsSplitArray {

	public class Pair {
		List<Integer> l1;
		List<Integer> l2;

		Pair(List<Integer> l1, List<Integer> l2) {
			this.l1 = l1;
			this.l2 = l2;
		}

		@Override
		public String toString() {
			return "Pair [l1=" + l1 + ", l2=" + l2 + "]";
		}
		
		
	}

	public static void main(String[] args) {
		int[] testIntArry = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		List<Pair> sol = new RecursionBacktrackingPermuationsSplitArray().permute(testIntArry);
		System.out.println(Arrays.deepToString(sol.toArray()));
	}

	public List<Pair> permute(int[] nums) {
		List<Pair> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), new ArrayList<>(), nums, 0);
		return list;
	}

	private void backtrack(List<Pair> list, List<Integer> bl1, List<Integer> bl2, int[] nums, int start) {
		if ((bl1.size() + bl2.size()) == nums.length) {
			list.add(new Pair(new ArrayList<>(bl1), new ArrayList<>(bl2)));
		} else {
			for (int i = start; i < nums.length; i++) {
				if(!bl1.contains(nums[i]) && !bl2.contains(nums[i])) {
					bl1.add(nums[i]);
					backtrack(list, bl1, bl2, nums, start + 1);
					bl1.remove(bl1.size() - 1);					
				}
				if(!bl2.contains(nums[i]) && !bl1.contains(nums[i])) {
					bl2.add(nums[i]);
					backtrack(list, bl1, bl2, nums, start + 1);
					bl2.remove(bl2.size() - 1);					
				}
			}
		}
	}

}