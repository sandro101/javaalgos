package algos;

class GraphAreaOfIsland {

	public static void main(String[] args) {
		int[][] grid = new int[][] { {0, 1, 1} };
		maxAreaOfIsland(grid);
	}
	
    public static int maxAreaOfIsland(int[][] grid) {
    	boolean[][] visited = new boolean[grid.length][grid[0].length];
    	int maxArea = 0;
    	for (int r = 0; r < grid.length; r++) {
        	for (int c = 0; c < grid[0].length; c++) {
            	maxArea = Math.max( 
            			calculateAreaUpToBoundary(r, c, visited, grid, grid.length, grid[0].length), 	
        			maxArea	
            	);
    		}
		}
		return maxArea;
        
    }
    
    private static int calculateAreaUpToBoundary(int r, int c, boolean[][] visited, int[][] grid, int maxRow, int maxColumn) {
    	if(hitWaterOrBeenHereBefore(r, c, visited, grid, maxRow, maxColumn)) {
    		return 0;
    	}  
    	visited[r][c] = true;
    	return( 
    		1 + 
    		calculateAreaUpToBoundary(r, c + 1,  visited, grid, maxRow, maxColumn) + 
    		calculateAreaUpToBoundary(r, c - 1,  visited, grid, maxRow, maxColumn) +
    		calculateAreaUpToBoundary(r + 1, c,  visited, grid, maxRow, maxColumn) + 
    		calculateAreaUpToBoundary(r - 1, c, visited, grid, maxRow, maxColumn)
    	);
    }

	private static boolean hitWaterOrBeenHereBefore(int r, int c, boolean[][] visited, int[][] grid, int maxRow, int maxColumn) {
		return outsideGrid(r, maxRow, c, maxColumn) || visited[r][c] || grid[r][c] == 0;
	}
    
    private static boolean outsideGrid(int r, int maxRow, int c, int maxColumn) {
    	return (r >= maxRow || c >= maxColumn || c < 0 || r < 0);
	}

}