//LeetCode link - https://leetcode.com/problems/reorder-list/description/

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

//Approach - 1
class Solution {
    public void reorderList(ListNode head) {
        //half the list

        ListNode otherHalf = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            otherHalf = otherHalf.next;
            fast = fast.next.next;
        }

        //reverse the list
        otherHalf = reverseList(otherHalf);

        ListNode firstHalf = head;

        while(firstHalf != null && otherHalf != null){
            ListNode fNext = firstHalf.next;
            ListNode oNext = otherHalf.next;

            firstHalf.next = otherHalf;
            otherHalf.next = fNext;

            firstHalf = fNext;
            otherHalf = oNext;
        }

        if(otherHalf != null)
            otherHalf.next = null;

        if(firstHalf != null)
            firstHalf.next = null;
    }

    private ListNode reverseList(ListNode head){
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

//other appraoches  - will include using extra space. We can store other half of the linkedlist in a DS like List or Stack, etc... then do the reordering.
