package algos;

class RecursionWordSearch {
	
	public static void main(String[] args) {
		//char[][] testGrid = new char[][] { {'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'} };
		//ABCCED
		char[][] testGrid = new char[][] { {'A','B'}, {'C', 'D'} };
		System.out.println(new RecursionWordSearch().exist(testGrid, "CDBA"));
	}
	
    public boolean exist(char[][] board, String word) {    	
    	for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				boolean[][] visited = new boolean[board.length][board[0].length];
				boolean found = checker(row, col, board, word, visited);
				if(found) return true;
			}
		}  
    	return false;
    }

	private boolean checker(int row, int col, char[][] board, String stillToFind, boolean[][] visited) {
		if(visited[row][col]) return false;		
		char currChar = stillToFind.charAt(0);
		if(stillToFind.length() == 1 && currChar == board[row][col]) {
			return true;
		}	
		
		if(currChar == board[row][col]) {
				visited[row][col] = true;
				boolean r1 = (row + 1 < board.length) ? checker(row + 1, col, board, stillToFind.substring(1), visited) : false;
				boolean r2 = (row - 1 >= 0) ? checker(row - 1, col, board, stillToFind.substring(1), visited) : false;
				boolean r3 = (col + 1 < board[0].length) ? checker(row, col + 1, board, stillToFind.substring(1), visited) : false;
				boolean r4 = (col - 1 >= 0) ? checker(row, col - 1, board, stillToFind.substring(1), visited) : false;
				return r1 || r2 || r3 || r4;
		} 	
		visited[row][col] = false;
		return false;		
	}

}	