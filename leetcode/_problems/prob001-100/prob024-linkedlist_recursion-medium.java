/*
    # 24. Swap Nodes in Pairs
    - Difficulty : Medium
    - Related Topics : Linked List, Recursion
    - Runtime : 0ms, Memory : 38.7MB
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = new ListNode(0, head);
        ListNode answer = head.next;
        ListNode current = head;
        
        while (current != null) {
            if (current.next == null) {
                break;
            }
            
            // swap
            ListNode tmp = current.next;
            prev.next = tmp;
            current.next = tmp.next;
            tmp.next = current;
            prev = current;
            current = current.next;
        }
        
        
        return answer;
    }
}