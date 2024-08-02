// Problem link - https://leetcode.com/problems/remove-nth-node-from-end-of-list/

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }

        int pos = (size - n);

        if(pos == 0){
            return head.next;
        }

        temp = head;
        while(pos-- > 1){
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }
}
