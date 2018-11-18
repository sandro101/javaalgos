package algos;

import java.util.HashSet;
import java.util.Set;

class LinkedListCycle {
	
	// https://leetcode.com/problems/linked-list-cycle/description/
	
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

    public boolean hasCycle(ListNode head) {
    	Set<ListNode> set = new HashSet<>();    	
        while(head != null) {
        	if(set.contains(head)) {
        		return true;
        	}
        	set.add(head);
        	head = head.next;
        }
        return false;
    }

    // no extra space
    public boolean hasCycleNoExtraSpace(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }   
    	ListNode fast = head.next;
        while(fast != null && fast.next != null) {
        	if(head == fast) return true;
            fast = fast.next.next;
            head = head.next;
        }
        return false;
    }
}