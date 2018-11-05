package algos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class BacktrackingBeatifulArrangments {
	
	// https://leetcode.com/problems/beautiful-arrangement/description/
	
	public static void main(String[] args) {
		System.out.println(new BacktrackingBeatifulArrangments().countArrangement(15));
	}
	
    public int countArrangement(int n) {
    	Set<List<Integer>> res = new HashSet<>();
        backtrack(n, new ArrayList<Integer>(), res);
        return res.size();
    }

	private void backtrack(int n, List<Integer> builder, Set<List<Integer>> res) {
		if(builder.size() == n && !res.contains(builder)) {
			res.add(new ArrayList<>(builder));
		}
		for(int i = 1; i <= n; i++) {
			if(!builder.contains(i)) {
				builder.add(i);
				if(isBa(builder)) backtrack(n, builder, res);
				builder.remove(builder.size() - 1);
			}
		}		
	}

	private boolean isBa(List<Integer> b) {
		for (int i = 0; i < b.size(); i++) {
			if(b.get(i) % (i + 1) != 0 && (i + 1) % b.get(i) != 0) return false;
		}
		return true;
	}
}