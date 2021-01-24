/*
	# 21. Merge Two Sorted Lists
	- Difficulty : Easy
	- Related Topics : Linked List, Recursion
	- Runtime : 1ms, Memory : 38.1MB
	- Concept : create new node and then input value & next node address
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode firstNode = null;
        
        ListNode prevNode = null;
        
        int val1 = 0;
        int val2 = 0;
        
        while (!(l1 == null && l2 == null)) {
        	if (l1 != null) {
        		val1 = l1.val;        		
        	} else {
        		val1 = Integer.MAX_VALUE;
        	}
        	if (l2 != null) {
        		val2 = l2.val;        		
        	} else {
        		val2 = Integer.MAX_VALUE;
        	}
        	
        	ListNode newNode = new ListNode();
        	if (val1 < val2) {
        		newNode.val = val1;
        		l1 = l1.next;
        	} else {
        		newNode.val = val2;
        		l2 = l2.next;
        	}
        	
        	if (prevNode != null) {
        		prevNode.next = newNode;        		
        	} else {
        		firstNode = newNode;
        	}
        	prevNode = newNode;
        }
        
        return firstNode;
    }
}