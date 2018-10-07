	package algos;

class GraphFloodFill {

	public static void main(String[] args) {
		int[][] grid = new int[][] { {1, 1, 1}, {1, 1, 0}, {1, 0, 1} };
		floodFill(grid, 1, 1, 2);
	}
	
    private static boolean[][] visited;
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        visited = new boolean[image.length][image[0].length];
        image = fill(sr, sc, image, image.length, image[0].length, image[sr][sc], newColor);
        return image;
    }    

    
    private static int[][] fill(int r, int c, int[][] grid, int maxRow, int maxColumn, int colour, int newColour) {
    	if(shouldFloodFill(r, c, grid, maxRow, maxColumn, colour) && !visited[r][c]) {
    		visited[r][c] = true;
    		grid[r][c] = newColour;
    		grid = fill(r, c + 1, grid, maxRow, maxColumn, colour, newColour); 
    		grid = fill(r, c - 1, grid, maxRow, maxColumn, colour, newColour);
    		grid = fill(r + 1, c, grid, maxRow, maxColumn, colour, newColour);
    		grid = fill(r - 1, c, grid, maxRow, maxColumn, colour, newColour);
    	}      	
		return grid;
    }

	private static boolean shouldFloodFill(int r, int c, int[][] grid, int maxRow, int maxColumn, int colour) {
		return !outsideGrid(r, maxRow, c, maxColumn) && grid[r][c] == colour;
	}
    
    private static boolean outsideGrid(int r, int maxRow, int c, int maxColumn) {
    	return (r >= maxRow || c >= maxColumn || c < 0 || r < 0);
	}

}