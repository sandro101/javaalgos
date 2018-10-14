package algos;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class LinkedListEvenNodesFirst {



	public static void main(String[] args) {
		LinkedListEvenNodesFirst gen = new LinkedListEvenNodesFirst();
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		four.next = five;
		three.next = four;
		two.next = three;
		one.next = two;
		gen.oddEvenList(one);
	}

	public ListNode oddEvenList(ListNode head) {
		if(head != null) {
			ListNode even = head.next;
			ListNode odd = head;
			ListNode evenHead = even;
			while (even != null && even.next != null) {
				odd.next = odd.next.next;
				even.next = even.next.next;
				even = even.next;
				odd = odd.next;
			}		
			odd.next = evenHead;		
			return head;
		}
		return null;		
	}
}
