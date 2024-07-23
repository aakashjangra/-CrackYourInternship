// Problem link - https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

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

//TC - O(n)
//SC - O(1)
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode ans = head;
        ListNode ptr = ans;

        head = head.next;

        while(head != null){
            if(head.val != ptr.val){
                ptr.next = head;

                ptr = ptr.next;
            }

            head = head.next;
        }

        ptr.next = null;

        return ans;
    }
}
