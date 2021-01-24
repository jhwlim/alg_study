/*
	# 21. Merge Two Sorted Lists
	- Runtime : 1ms, Memory : 39.4MB
	- Concept : instead of creating new node, change the address of next node which is privided as parameters 
*/
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode beforeResultNode = new ListNode();
        ListNode prevNode = beforeResultNode;
        
        while (!(l1 == null && l2 == null)) {
        	if (l1 == null) {
        		prevNode.next = l2;
        		l2 = l2.next;
        	} else if (l2 == null) {
        		prevNode.next = l1;
                l1 = l1.next;
        	} else {
        		if (l1.val < l2.val) {
            		prevNode.next = l1;
                    l1 = l1.next;
                } else {
                	prevNode.next = l2;
                	l2 = l2.next;
                }
        	}
        	
        	prevNode = prevNode.next;
        }
        
        return beforeResultNode.next;
    }
}