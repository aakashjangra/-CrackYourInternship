// Problem link - https://leetcode.com/problems/reverse-linked-list/description/

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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode p = head, c = head.next, n = head.next.next;

        while(n != null){
            c.next = p; //reversing the pointer

            p = c;
            c = n;
            n = n.next;
        }

        c.next = p;
        head.next = null;

        return c;
    }
}
