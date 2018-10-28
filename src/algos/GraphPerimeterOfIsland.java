package algos;

class GraphPerimeterOfIsland {

	public static void main(String[] args) {
		int[][] testGrid = new int[][] { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		System.out.println(new GraphPerimeterOfIsland().islandPerimeter(testGrid));
	}

	public int islandPerimeter(int[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int[] islandsAndEdges = new int[2];
		dfs(grid, visited, islandsAndEdges, 0, 0);
		return 4 * islandsAndEdges[0] - islandsAndEdges[1];
	}

	private void dfs(int[][] grid, boolean[][] visited, int[] islandsAndEdges, int row, int col) {
		if (inGrid(grid, row, col) && !visited[row][col]) {
			if (grid[row][col] == 1) {
				islandsAndEdges[0]++;
				islandsAndEdges[1] += getEdgeCount(grid, row, col);
			}
			visited[row][col] = true;
			dfs(grid, visited, islandsAndEdges, row + 1, col);
			dfs(grid, visited, islandsAndEdges, row - 1, col);
			dfs(grid, visited, islandsAndEdges, row, col + 1);
			dfs(grid, visited, islandsAndEdges, row, col - 1);
		}
	}

	private int getEdgeCount(int[][] grid, int row, int col) {
		int edges = 0;
		edges += (inGrid(grid, row + 1, col) && grid[row + 1][col] == 1) ? 1 : 0; 
		edges += (inGrid(grid, row - 1, col) && grid[row - 1][col] == 1) ? 1 : 0; 
		edges += (inGrid(grid, row, col + 1) && grid[row][col + 1] == 1) ? 1 : 0; 
		edges += (inGrid(grid, row, col - 1) && grid[row][col - 1] == 1) ? 1 : 0; 
		return edges;
	}

	private boolean inGrid(int[][] grid, int row, int col) {
		return !(row >= grid.length || row < 0 || col >= grid[0].length || col < 0);
	}
}