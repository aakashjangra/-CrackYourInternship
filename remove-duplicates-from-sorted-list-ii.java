// Problem link - https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        int prev = head.val - 1;

        while(head != null && head.next != null){
            if(head.val != prev && head.val != head.next.val){
                dummy.next = head;
                dummy = dummy.next;
            }

            while(head != null && head.next != null && head.val == head.next.val){
                head = head.next;
            }

            prev = head.val;
            head = head.next;
        }

        if(head != null){
            dummy.next = head;
            dummy = dummy.next;
        }

        dummy.next = null;

        return ans.next;
    }
}
