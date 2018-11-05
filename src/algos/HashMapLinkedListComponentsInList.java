package algos;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class HashMapLinkedListComponentsInList {

	// https://leetcode.com/problems/linked-list-components/description/
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public int numComponents(ListNode head, int[] g) {
		Set<Integer> set = Arrays.stream(g).boxed().collect(Collectors.toSet());
		int count = 0;			
		while(head != null) {
			if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) {
				count++;
			}
			head = head.next;
		}
		return count;
	}
}