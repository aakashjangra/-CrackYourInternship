// Problem link - https://leetcode.com/problems/palindrome-linked-list/

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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true; // palindrome

        // break in half, using slow - fast pointer
        ListNode slow = head, fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;

            fast = fast.next.next;
        }
        // reverse second half
        ListNode reversed = reverseLL(slow);

        // match first and second half
        while(head != null && reversed != null){
            if(head.val != reversed.val) return false; //not a palindrome

            head = head.next;
            reversed = reversed.next;
        }

        return true;
    }

    private ListNode reverseLL(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode p = head, c = head.next, n = head.next.next;

        while(n != null){
            c.next = p;

            p = c;
            c = n;
            n = n.next;
        }

        c.next = p;
        head.next = null;

        return c;
    }
}
