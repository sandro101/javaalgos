package algos.test;

import java.util.Arrays;
import java.util.LinkedList;

import algos.UnsortedLinkedListSorter;

public class UnsortedLinkedListTest {

	public static void main(String[] args) {
		System.out.println("Running REMOVE DUPES");
		removeDupesRunner();
		System.out.println("Running REMOVE NTH LAST ENTRY");
		removeNthToLastEntryRunner();	
		System.out.println("Running SUM NUMBERS");
		sumNumbersRunner();
	}

	private static void sumNumbersRunner() {
		UnsortedLinkedListSorter calculator = new UnsortedLinkedListSorter();
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		l1.addAll(Arrays.asList(0, 1, 9, 9, 9));	
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l2.addAll(Arrays.asList(0, 9, 9));
		
		LinkedList<Integer> expected = new LinkedList<Integer>();
		expected.addAll(Arrays.asList(0, 0, 9, 0, 0, 1));
		runAssert(calculator.add(l1, l2), expected);
	}

	private static void removeNthToLastEntryRunner() {
		UnsortedLinkedListSorter getter = new UnsortedLinkedListSorter();
		//Input
		LinkedList<String> ll = new LinkedList<String>();
		ll.addAll(Arrays.asList("entry 1", "entry 2", "entry 3", "entry 2"));
		try {
			runAssert(getter.getNthElementFromEnd(ll, 1), "entry 3");
			runAssert(getter.getNthElementFromEnd(ll, 0), "entry 2");
			runAssert(getter.getNthElementFromEnd(ll, 3), "entry 1");
		} catch (IllegalAccessException e) {
			System.out.println("false");
		}	
		
		try {
			runAssert(getter.getNthElementFromEnd(ll, 10), "");
		} catch (IllegalAccessException e) {
			System.out.println("true");
		}
	}

	private static void removeDupesRunner() {
		UnsortedLinkedListSorter sorter = new UnsortedLinkedListSorter();
		//Input
		LinkedList<String> ll = new LinkedList<String>();
		ll.addAll(Arrays.asList("entry 1", "entry 2", "entry 3", "entry 2"));
		//Expected
		LinkedList<String> expected = new LinkedList<String>();		
		expected.addAll(Arrays.asList("entry 1", "entry 2", "entry 3"));
		runAssert(sorter.removeDupes(ll), expected);
		
		//Input
		LinkedList<String> ll2 = new LinkedList<String>();
		ll2.addAll(Arrays.asList("entry 3", "entry 1", "entry 2", "entry 2"));
		//Expected
		LinkedList<String> expected2 = new LinkedList<String>();		
		expected2.addAll(Arrays.asList("entry 3", "entry 1", "entry 2"));
		runAssert(sorter.removeDupes(ll2), expected2);
		
		//Input
		LinkedList<String> ll3 = new LinkedList<String>();
		ll3.addAll(Arrays.asList("entry 3", "entry 2", "entry 1", "entry 2", "entry 2"));
		//Expected
		LinkedList<String> expected3 = new LinkedList<String>();		
		expected3.addAll(Arrays.asList("entry 3", "entry 2", "entry 1"));
		runAssert(sorter.removeDupes(ll3), expected3);
	}
	
	private static void runAssert(Object actual, Object expected) {
		Boolean pass = expected.equals(actual);
		System.out.println(pass.toString());
	}
}
