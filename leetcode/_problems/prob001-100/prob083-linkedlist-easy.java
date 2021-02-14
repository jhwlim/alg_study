/*
	# 83. Remove Duplicates from Sorted List
	- Difficulty : Easy
	- Related Topics : Linked List
	- Runtime : 0ms, Memory : 38.2MB 
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
	public ListNode deleteDuplicates(ListNode head) {
		
		if (head == null) {
			return null;
		}
		
		ListNode prevNode = head;
		ListNode tmpNode = head;
		
		while (head.next != null) {
			head = head.next;
			if (head.val == tmpNode.val) {
				if (head.next == null) {
					tmpNode.next = null;
				}    
			} else {
				tmpNode.next = head;
				tmpNode = head;
			}
			
		}
		
		return prevNode;
    }
}