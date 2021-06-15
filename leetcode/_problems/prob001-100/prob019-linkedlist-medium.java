/*
	# 19. Remove Nth Node From End of List
	- Difficulty : Medium
	- Related Topics : Linked List, Two Pointers
	- Runtime : 0ms, Memory : 37.1MB
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        
        int m = n;
        int len = 0;
        while (fast != null) {
            if (m-- < 0) {
                slow = slow.next;
            }
            fast = fast.next;
            len++;
        }
        
        if (len == n) {
            head = head.next;
        } else {
            slow.next = slow.next.next;
        }
        
        return head;
    }
}