/*
    # 92. Reverse Linked List II
    - Difficulty : Medium
    - Related Topics : Linked List
    - Runtime : 0ms, Memory : 36.6MB 
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode curr = head;
        int i = 0;
        while (i++ < left-1) {
            prev = curr;
            curr = curr.next;
        }
        
        ListNode prevRevHead = prev;
        ListNode revTail = curr;
        
        prev = curr;
        curr = curr.next;
        while (i++ < right) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        
        revTail.next = curr;    
        if (prevRevHead == null) {
            return prev;
        } else {
            prevRevHead.next = prev;
            return head;    
        }
    }
    
}