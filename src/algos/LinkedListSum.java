package algos;

class LinkedListSum {
	
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
		
		ListNode out = new LinkedListSum().addTwoNumbers(one, three);
		while(out.next != null) {
			System.out.print(out.val + "->");
			out = out.next;
		}
		System.out.print(out.val);
		
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode sum = new ListNode(-1);
    	ListNode holder = sum;
    	int carry = 0;
    	while(l1 != null && l2 != null) {
    		int sv = l1.val + l2.val + carry;    		
    		ListNode sn = new ListNode(sv % 10);
    		carry = sv / 10;    		
    		sum.next = sn;
    		sum = sum.next;
    		l1 = l1.next;
    		l2 = l2.next;
    	}
    	while(l1 != null) {
    		int sv = l1.val + carry;    		
    		ListNode sn = new ListNode(sv % 10);
    		carry = sv / 10;    		
    		sum.next = sn;
    		sum = sum.next;
    		l1 = l1.next;
    	}
    	while(l2 != null) {
    		int sv = l2.val + carry;    		
    		ListNode sn = new ListNode(sv % 10);
    		carry = sv / 10;    		
    		sum.next = sn;
    		sum = sum.next;
    		l2 = l2.next;
    	}
    	if(carry > 0) {
    		ListNode sn = new ListNode(carry);
    		sum.next = sn;
    	}
		return holder.next;        
    }
}