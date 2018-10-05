package establishedalgos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import establishedalgos.datastructures.BinaryTreeNode;
import establishedalgos.datastructures.GraphNode;
import establishedalgos.datastructures.SortOrder;
import establishedalgos.datastructures.TreeNode;

public class Algos {

	public static <T extends Comparable<T>> List<T> bubbleSort(List<T> list, SortOrder order) {
		int length = list.size();
		for (int i = 1; i < length; i++) {
			for (int j = 0; j < length - 1; j++) {
				if (list.get(j).compareTo(list.get(j + 1)) == order.getOrder()) {
					System.out.printf("swapping %d with %s", list.get(j + 1), list.get(j));
					System.out.println("");
					list.add(j + 1, list.remove(j));
				}
				if (list.get(j).compareTo(list.get(j + 1)) == order.getOrder()) {
					System.out.printf("swapping	 %d with %s", list.get(j), list.get(j + 1));
					System.out.println("");
					list.add(j, list.remove(j + 1));
				}
			}
		}
		return list;
	}

	public static long candies(int n, int[] arr) {
		long[] sweets = new long[n];
		if (arr.length == 0)
			return 0;
		sweets[0] = 1;
		if (arr.length == 1) {
			return sweets[0];
		}
		for (int i = 1; i < n; i++) {
			if (arr[i - 1] == arr[i]) {
				sweets[i] = 1;
			}
			if (arr[i - 1] < arr[i]) {
				sweets[i] = (sweets[i - 1] + 1);
			}
			if (arr[i - 1] > arr[i]) {
				sweets[i] = 1;
				int j = i;
				while (arr[j - 1] > arr[j] && j >= 0) {
					if(sweets[j - 1] == sweets[j]) {
						sweets[j - 1]++;
					}
					j--;
				}
			}
		}
		return Arrays.stream(sweets).sum();

	}

	public static List<Integer> countingSort(List<Integer> list, SortOrder order) {
		int maxValue = list.stream().max((i, j) -> i.compareTo(j)).get();
		int[] counts = IntStream.generate(() -> 0).limit(maxValue + 1).toArray();
		for (int i = 0; i < list.size(); i++) {
			counts[list.get(i)] += 1;
		}
		List<Integer> sorted = new ArrayList<Integer>();
		for (int j = 0; j < counts.length; j++) {
			int count = counts[j];
			for (int k = count; k > 0; k--) {
				sorted.add(j);
			}
		}
		if (order.equals(SortOrder.ASCENDING)) {
			return sorted;
		} else {
			Collections.reverse(sorted);
			return sorted;
		}
	}

	private static List<Integer> countingSort(List<Integer> list, int digitIdentifier) {
		int maxValue = 9;
		int[] counts = IntStream.generate(() -> 0).limit(maxValue + 1).toArray();
		for (int i = 0; i < list.size(); i++) {
			// this says, divide by 1, 10, 100 . . . and then mode the answer by 10.
			// i.e. 137/10%10 => 13%10 => 3
			counts[getDigit(list, digitIdentifier, i)] += 1;
		}
		for (int j = 1; j < counts.length; j++) {
			counts[j] += counts[j - 1];
		}
		List<Integer> sorted = IntStream.generate(() -> 0).boxed().limit(list.size()).collect(Collectors.toList());
		for (int k = list.size() - 1; k >= 0; k--) {
			sorted.set(counts[getDigit(list, digitIdentifier, k)] - 1, list.get(k));
			counts[getDigit(list, digitIdentifier, k)]--;
		}
		return sorted;
	}

	public static List<Integer> radixSort(List<Integer> list, SortOrder order) {
		int maxValue = list.stream().max((i, j) -> i.compareTo(j)).get();
		for (int i = 1; i <= maxValue; i *= 10) {
			list = countingSort(list, i);
		}
		if (order.equals(SortOrder.ASCENDING)) {
			return list;
		} else {
			Collections.reverse(list);
			return list;
		}
	}

	public static List<Integer> freqQuery(List<int[]> queries) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> mapInvert = new HashMap<Integer, Integer>();
		List<Integer> res = new ArrayList<Integer>();

		for (int[] q : queries) {
			int op = q[0];
			int val = q[1];
			int freq = map.getOrDefault(val, 0);
			if (op == 1) {
				map.merge(val, 1, (e, n) -> e + n);
				mapInvert.merge(freq, 1, (e, n) -> e + n);
				mapInvert.merge(freq - 1, 0, (e, n) -> Math.max(0, e - 1));
			}
			if (op == 2) {
				map.merge(val, 0, (e, n) -> Math.max(0, e - 1));
				mapInvert.merge(freq, 1, (e, n) -> e + n);
				mapInvert.merge(freq + 1, 0, (e, n) -> Math.max(0, e - 1));
			}
			if (op == 3) {
				res.add((mapInvert.containsKey(val)) ? 1 : 0);
			}
		}
		return res;
	}

	public static <T extends Comparable<T>> List<T> mergeSort(List<T> list, SortOrder sort) {
		int length = list.size();
		if (length <= 1)
			return list;
		int midPoint = length / 2;
		List<T> left = list.stream().limit(midPoint).collect(Collectors.toList());
		List<T> right = list.stream().skip(midPoint).collect(Collectors.toList());
		left = mergeSort(left, sort);
		right = mergeSort(right, sort);
		return merge(left, right, sort);
	}

	private static <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right, SortOrder sort) {
		List<T> result = new ArrayList<T>();
		ListIterator<T> lIter = left.listIterator();
		ListIterator<T> rIter = right.listIterator();
		while (lIter.hasNext() && rIter.hasNext()) {
			T l = lIter.next();
			T r = rIter.next();
			if (l.compareTo(r) == sort.getOrder()) {
				result.add(l);
				lIter.remove();
				rIter.previous();
			} else {
				result.add(r);
				rIter.remove();
				lIter.previous();
			}
		}
		while (lIter.hasNext()) {
			result.add(lIter.next());
			lIter.remove();
		}
		while (rIter.hasNext()) {
			result.add(rIter.next());
			rIter.remove();
		}
		return result;

	}

	public static <T extends Comparable<T>> void quickSort(List<T> list) {
		quickSortHelper(list, 0, list.size() - 1);
	}

	private static <T extends Comparable<T>> void quickSortHelper(List<T> list, int left, int right) {
		int partition = swapAndLocatePartitionPoint(list, left, right);
		// if there is still something on the left to sort
		if (left < partition - 1)
			quickSortHelper(list, left, partition - 1);
		// if there is still something on the right to sort
		if (partition < right)
			quickSortHelper(list, partition, right);
	}

	private static <T extends Comparable<T>> int swapAndLocatePartitionPoint(List<T> list, int left, int right) {
		int i = left;
		int j = right;
		T pivot = list.get(Math.floorDiv(left + right, 2));
		// keep trying to swap while the pointers haven't crossed
		while (i <= j) {
			// find a value on the left which is larger than the pivot
			while (list.get(i).compareTo(pivot) < 0) {
				i++;
			}
			// find a value on the right which is smaller than the pivot
			while (list.get(j).compareTo(pivot) > 0) {
				j--;
			}
			// if we haven't crossed the pointers in our search then swap the values over to
			// the other side of the pivot
			if (i <= j) {
				swap(list, i, j);
				i++;
				j--;
			}
		}
		return i;
	}

	private static <T extends Comparable<T>> void swap(List<T> list, int left, int right) {
		T larger = list.get(right);
		list.set(right, list.get(left));
		list.set(left, larger);
	}

	public static <T> void bfsOfBinaryTree(BinaryTreeNode<T> rootNode) {
		Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
		queue.add(rootNode);
		while (!queue.isEmpty()) {
			BinaryTreeNode<T> parent = queue.poll();
			System.out.printf("Visited node %s", parent.data);
			System.out.println();
			if (parent.left != null) {
				queue.add(parent.left);
			}
			if (parent.right != null) {
				queue.add(parent.right);
			}
		}
	}

	public static <T> void bfsOfTree(TreeNode<T> rootNode) {
		Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
		queue.add(rootNode);
		while (!queue.isEmpty()) {
			TreeNode<T> parent = queue.poll();
			System.out.printf("Visited node %s", parent.data);
			System.out.println();
			Iterator<TreeNode<T>> children = parent.children.iterator();
			while (children.hasNext()) {
				queue.add(children.next());
			}
		}
	}

	public static <T> void bfsOfGraph(GraphNode<T> node) {
		Queue<GraphNode<T>> queue = new LinkedList<GraphNode<T>>();
		Set<GraphNode<T>> visited = new HashSet<GraphNode<T>>();
		queue.add(node);
		while (!queue.isEmpty()) {
			node = queue.poll();
			System.out.printf("Visited node %s", node.data);
			System.out.println();
			visited.add(node);
			Iterator<GraphNode<T>> adjacents = node.adjacents.iterator();
			while (adjacents.hasNext()) {
				GraphNode<T> adj = adjacents.next();
				if (!visited.contains(adj)) {
					queue.add(adj);
				} else {
					System.out.printf("Already visited node %s", adj.data);
					System.out.println();
				}
			}
		}
	}

	public static <T> void dfsOfBinaryTree(BinaryTreeNode<T> node, String order) {
		if (node != null) {
			switch (order) {
			case "in":
				inOrder(node);
				break;
			case "pre":
				preOrder(node);
				break;
			case "post":
				postOrder(node);
				break;
			default:
				throw (new RuntimeException("Don't know what to do with: " + order));
			}

		}
	}

	public static <T> void dfsOfTree(TreeNode<T> node, String order) {
		if ("pre".equals(order)) {
			System.out.printf("Visited node %s", node.data);
			System.out.println();
		}
		;
		Iterator<TreeNode<T>> children = node.children.iterator();
		while (children.hasNext()) {
			dfsOfTree(children.next(), order);
		}
		if ("post".equals(order)) {
			System.out.printf("Visited node %s", node.data);
			System.out.println();
		}
		;
	}

	public static <T> void dfsOfGraph(GraphNode<T> node, String order, Set<GraphNode<T>> visited) {
		if ("pre".equals(order) && !visited.contains(node)) {
			visited.add(node);
			System.out.printf("Visited node %s", node.data);
			System.out.println();
		}
		;
		Iterator<GraphNode<T>> adjacents = node.adjacents.iterator();
		while (adjacents.hasNext()) {
			dfsOfGraph(adjacents.next(), order, visited);
		}
		if ("post".equals(order) && !visited.contains(node)) {
			visited.add(node);
			System.out.printf("Visited node %s", node.data);
			System.out.println();
		}
		;
	}

	private static <T> void inOrder(BinaryTreeNode<T> node) {
		dfsOfBinaryTree(node.left, "in");
		System.out.printf("Visited node %s", node.data);
		System.out.println();
		dfsOfBinaryTree(node.right, "in");
	}

	private static <T> void preOrder(BinaryTreeNode<T> node) {
		System.out.printf("Visited node %s", node.data);
		System.out.println();
		dfsOfBinaryTree(node.left, "pre");
		dfsOfBinaryTree(node.right, "pre");
	}

	private static <T> void postOrder(BinaryTreeNode<T> node) {
		dfsOfBinaryTree(node.left, "post");
		dfsOfBinaryTree(node.right, "post");
		System.out.printf("Visited node %s", node.data);
		System.out.println();
	}

	private static int getDigit(List<Integer> list, int digitIdentifier, int position) {
		return list.get(position) / digitIdentifier % 10;
	}

}
