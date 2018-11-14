package algos;

import java.util.LinkedList;
import java.util.Queue;

class GraphCourses {
	
	// https://leetcode.com/problems/course-schedule/description/

	public static void main(String[] args) {
		int[][] testGrid = new int[][] { { 1, 0 }, { 0, 1 } };
		System.out.println(new GraphCourses().canFinish(2, testGrid));
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[][] matrix = new int[numCourses][numCourses]; // i -> j
		int[] indegree = new int[numCourses];

		for (int i = 0; i < prerequisites.length; i++) {
			int ready = prerequisites[i][0];
			int pre = prerequisites[i][1];
			if (matrix[pre][ready] == 0)
				indegree[ready]++; // duplicate case
			matrix[pre][ready] = 1;
		}

		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0)
				queue.offer(i);
		}
		while (!queue.isEmpty()) {
			int course = queue.poll();
			count++;
			for (int i = 0; i < numCourses; i++) {
				if (matrix[course][i] != 0) {
					if (--indegree[i] == 0)
						queue.offer(i);
				}
			}
		}
		return count == numCourses;
	}

}