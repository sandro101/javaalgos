package algos.test;

import algos.PathGameDiv2;

public class PathGameDiv2Test {
	public static void main(String[] args) {
		String[] board = new String[] { 
			"....#.##.....#...........", 
			"..#......#.......#..#...." 
		};

		System.out.println(new PathGameDiv2().calc(board));
	}
}
