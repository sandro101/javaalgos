package algos;

class DPUniquePathsWithObstacles {

	public static void main(String[] args) {
		int[][] testGrid = new int[][] {
			{ 0, 1, 0 },
			{ 0, 0, 0 },
			{ 0, 0, 0 }
		};
		//int[][] testGrid2 = new int[][] {
		//	{ 0, 0 },
		//};
		System.out.println(uniquePathsWithObstacles(testGrid));
	}

	public static int uniquePathsWithObstacles(int[][] og) {
		int[][] nPaths = new int[og.length][og[0].length];
		nPaths[0][0] = (og[0][0] == 1) ? 0 : -1;
		for (int r = 0; r < og.length; r++) {
			for (int c = 0; c < og[0].length; c++) {
				if(r != 0)
					nPaths[r][0] = (og[r][0] == 1 || nPaths[r - 1][0] == 0) ? 0 : -1;
				if(c != 0)
					nPaths[0][c] = (og[0][c] == 1 || nPaths[0][c - 1] == 0) ? 0 : -1;
			}
		}
		for (int r = 1; r < og.length; r++) {
			for (int c = 1; c < og[0].length; c++) {
				if(og[r][c] == 1) {
					nPaths[r][c] = 0;
				} else {
					nPaths[r][c] = nPaths[r][c - 1] + nPaths[r - 1][c];
				}				
			}
		}
		return nPaths[og.length - 1][og[0].length - 1] * -1;
	}
}