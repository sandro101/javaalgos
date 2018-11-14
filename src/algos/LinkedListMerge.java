package algos;

class LinkedListMerge {
	
	// 21 leetcode
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode r = new ListNode(-1);
        ListNode h = r;
        while(l1 != null && l2 !=null){
            if(l1.val < l2.val){
                r.next = new ListNode(l1.val);                
                l1 = l1.next;
            } else {
                r.next = new ListNode(l2.val);                                
                l2 = l2.next;
            }
            r = r.next;
        }
        while(l1 != null){
            r.next = new ListNode(l1.val);
            r = r.next;
            l1 = l1.next;
        }
        while(l2 != null){
            r.next = new ListNode(l2.val);
            r = r.next;
            l2 = l2.next;
        }        
        return h.next;
    }
}