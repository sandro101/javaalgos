package algos;

class LinkedListReverse {
	
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		four.next = five;
		three.next = four;
		two.next = three;
		one.next = two;
		
		ListNode reversed = new LinkedListReverse().reverseList(one);
		while(reversed.next != null) {
			System.out.print(reversed.val + "->");
			reversed = reversed.next;
		}
		
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseList(ListNode head) {	
		ListNode newTail = new ListNode(head.val);
		while(head != null) {
			ListNode parent = new ListNode(head.val);
			parent.next = newTail;
			newTail = parent;
			head = head.next;
		}
		return newTail;			
	}
}