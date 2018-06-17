package algos;

import java.util.Arrays;

public class PathGameDiv2 {
	public int calc(String[] board) {
		char[] first = board[0].toCharArray();
		char[] second = board[1].toCharArray();	
		return Math.max(countReplacements(first, second), countReplacements(second, first));		
	}

	private int countReplacements(char[] startingRow, char[] alternateRow) {
		int blackCount = 0;
		for(int i = 0; i < startingRow.length - 1; i++) {
			if(startingRow[i] == ".".charAt(0)) {
				if(startingRow[i+1] == ".".charAt(0) && alternateRow[i] == ".".charAt(0)) {
					blackCount++;
				}
			}else {
				blackCount += countReplacements(
					Arrays.copyOfRange(alternateRow, i-1, alternateRow.length - 1),
					Arrays.copyOfRange(startingRow, i-1, startingRow.length - 1)					
				);
				break;
				
			}
		}
		return blackCount;
	}
}
