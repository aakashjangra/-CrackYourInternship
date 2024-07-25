// Problem link - https://leetcode.com/problems/reverse-linked-list-ii/

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

// TC - O(n)
// SC - O(1)
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right){
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode leftNode = dummy;

        int pos = 0;
        while(pos < left - 1){
            leftNode = leftNode.next;
            pos++;
        }

        ListNode newRight = leftNode.next;
        ListNode c = newRight;
        ListNode p = null;
        ListNode n = c.next;

        while(left <= right){
            n = c.next;
            c.next = p;
            
            p = c;
            c = n;

            left++;
        }

        leftNode.next = p;
        newRight.next = c;

        return dummy.next;
    }
}
