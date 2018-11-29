package algos;

import java.util.LinkedList;
import java.util.Queue;

class GraphCourses {
	
	// https://leetcode.com/problems/course-schedule/description/

	public static void main(String[] args) {
		int[][] testGrid = new int[][] { { 1, 0 }, { 0, 1 } };
		System.out.println(new GraphCourses().canFinish(2, testGrid));
	}

	// logic as follows: prereq looks like this (course, prereq)
	// for each course increment the prereqCount and mark there being a connection between
	// the two courses in the matrix. First for each course with no prereq add them to the queue
	// then while the queue is not empty take a course, increment count and check that now it has been completed
	// if there are any additional courses which can be taken, i.e was there a connection between this course and any other
	// for which the prereq has now reduced to zero by virtue of studying this course. If there are add them to the queue
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[][] matrix = new int[numCourses][numCourses]; // i -> j
		int[] prereqCount = new int[numCourses];

		for (int i = 0; i < prerequisites.length; i++) {
			int course = prerequisites[i][0];
			int pre = prerequisites[i][1];
			prereqCount[course]++; 
			matrix[pre][course] = 1;
		}

		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < prereqCount.length; i++) {
			if (prereqCount[i] == 0)
				queue.offer(i);
		}
		while (!queue.isEmpty()) {
			int course = queue.poll();
			count++;
			for (int i = 0; i < numCourses; i++) {
				if (matrix[course][i] != 0) {
					if (--prereqCount[i] == 0)
						queue.offer(i);
				}
			}
		}
		return count == numCourses;
	}

}