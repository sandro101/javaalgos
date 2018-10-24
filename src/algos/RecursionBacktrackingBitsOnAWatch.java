package algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class RecursionBacktrackingBitsOnAWatch {
	
	public List<String> readBinaryWatch(int num) {
    	int[] bitReps = new int[] { 1, 2, 4, 8, 16, 32, 60, 120, 240, 480 };
    	Set<Integer> time = new HashSet<Integer>(); 
    	List<Integer> times = new ArrayList<Integer>(); 
    	List<String> sol = new ArrayList<String>(); 
        backtrack(num, time, 0, times, bitReps);  
        Collections.sort(times);
        for (Integer t : times) {
        	String t2 = convetToTime(t);
        	if(t2 != "") 
        		sol.add(t2);
		}        
        return sol;
    }

	private void backtrack(int num, Set<Integer> time, int start, List<Integer> times, int[] bitReps) {
		if(start == num) {	
			int t = time.stream().mapToInt(x -> (Integer)x).sum();
			int minsTotal = time.stream().mapToInt(x -> (Integer)x).filter(x-> x < 60).sum();
			if(!times.contains(t) && minsTotal < 60 && t < 720) {
				times.add(t);
			}				
			return;
		}
		for(int i = start; i < bitReps.length; i++) {			
			if(time.contains(bitReps[i])) continue;
			time.add(bitReps[i]);
			backtrack(num, time, start + 1, times, bitReps);
			time.remove(bitReps[i]);
		}
		
	}

	private String convetToTime(Integer t) {
		int hours = t / 60;
		int mins = t % 60;	
        if(hours >= 12){
            return "";
        }
        if(mins >= 60){
            return "";
        }
		return String.format("%1d:%02d", hours, mins);		
	}
    
}