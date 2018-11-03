package algos;

class LinkedListRemoveAllWithVal {
	
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public ListNode removeElements(ListNode head, int val) {
		if(head == null) return null;
		ListNode holder = head;
		while(head.next != null) {
			if(head.next.val == val) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}
		return (holder.val == val) ? holder.next : holder;
	}

}