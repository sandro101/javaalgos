package algos;

class LinkedListSwapAdjacentNodes {
	// https://leetcode.com/problems/swap-nodes-in-pairs/description/
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
    	ListNode runner = head;
    	while(runner.next != null) {
    		int temp = runner.val;
    		runner.val = runner.next.val;
    		runner.next.val = temp;
    		if(runner.next.next != null) {
    			runner = runner.next.next;
    		} else {
    			break;
    		}
    	}
        return head;
    }

}