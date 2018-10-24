package algos;

class LinkedListMiddleNode {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode middleNode(ListNode head) {
		if(head.next == null) return head;
    	ListNode p = head;    	
    	ListNode fp = head.next;
        while(fp.next != null && fp.next.next != null) {
        	fp = fp.next.next;
        	p = p.next;
        }        
        return p.next;
    }

}