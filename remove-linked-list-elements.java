// Problem Link - https://leetcode.com/problems/remove-linked-list-elements/description/

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
// SC - O(n)

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;

        while(head != null){
            if(head.val != val){
                ptr.next = head;

                ptr = ptr.next;
            }

            head = head.next;
        }

        ptr.next = null;

        return dummy.next;
    }
}
