package algos;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class StackExclusiveTimeOfFunction {

	// https://leetcode.com/problems/exclusive-time-of-functions/description/

	public static void main(String[] args) {
		String[] logs = new String[] { 
			"0:start:0", "1:start:5", "2:start:6", "3:start:9", "4:start:11", "5:start:12",
			"6:start:14", "7:start:15", "1:start:24", "1:end:29", "7:end:34", "6:end:37", "5:end:39", "4:end:40",
			"3:end:45", "0:start:49", "0:end:54", "5:start:55", "5:end:59", "4:start:63", "4:end:66", "2:start:69",
			"2:end:70", "2:start:74", "6:start:78", "0:start:79", "0:end:80", "6:end:85", "1:start:89", "1:end:93",
			"2:end:96", "2:end:100", "1:end:102", "2:start:105", "2:end:109", "0:end:114" 
		};
		
		int[] sol = new StackExclusiveTimeOfFunction().exclusiveTime(8, Arrays.asList(logs));
		System.out.println(Arrays.toString(sol));
	}

	public int[] exclusiveTime(int n, List<String> logs) {
		Stack<String> concurrentTasks = new Stack<>();
		int[] sol = new int[n];
		for (int i = 0; i < logs.size(); i++) {
			String[] nextProcess = logs.get(i).split(":");
			String startOrEnd = nextProcess[1];
			if (startOrEnd.equals("start")) {
				if (!concurrentTasks.isEmpty()) {
					String[] currentProcess = concurrentTasks.pop().split(":");
					int currentId = Integer.parseInt(currentProcess[0]);
					int currentStartTime = Integer.parseInt(currentProcess[2]);
					int nextProcessStartTime = Integer.parseInt(nextProcess[2]);
					sol[currentId] += (nextProcessStartTime - currentStartTime);
					// add the time the current process finished, i.e. the time the next one started
					concurrentTasks.push(String.format("%s:interrupted:%s", currentId, nextProcessStartTime));
				}
				concurrentTasks.push(logs.get(i));
			} else {
				String[] currentProcess = concurrentTasks.pop().split(":");
				int currentId = Integer.parseInt(currentProcess[0]);
				int currentStartTime = Integer.parseInt(currentProcess[2]);
				int currentProcessEndTime = Integer.parseInt(nextProcess[2]);
				sol[currentId] += (currentProcessEndTime - currentStartTime + 1);				
				// Was anything interrupted?
				if(!concurrentTasks.isEmpty()) {
					// Add the interrupted process back onto the top of the concurrentTasks. 
					// It can start again one unit after the current process finishes
					String interruptedProcessId = concurrentTasks.pop().split(":")[0];
					concurrentTasks.push(String.format("%s:start:%s", interruptedProcessId, currentProcessEndTime + 1));
				}				
			}
		}
		return sol;
	}
}