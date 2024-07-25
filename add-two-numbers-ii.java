// Problem link - https://leetcode.com/problems/add-two-numbers-ii/

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

// TC - O(m + n)
// SC - O(m + n) --- counting input list length in space complexity because it is being used in the algorithm, in deriving the answer
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode dummy = new ListNode(-1);
        ListNode sum = dummy;

        int carry = 0;

        while(l1 != null && l2 != null){
            int num = l1.val + l2.val + carry;

            carry = (num / 10);
            num = (num % 10);

            sum.next = new ListNode(num);

            sum = sum.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        // if l1 has digits left
        while(l1 != null){
            int num = l1.val + carry;

            carry = (num / 10);
            num = (num % 10);

            sum.next = new ListNode(num);

            sum = sum.next;
            l1 = l1.next;
        }

        //if l2 has digits left
        while(l2 != null){
            int num = l2.val + carry;

            carry = (num / 10);
            num = (num % 10);

            sum.next = new ListNode(num);

            sum = sum.next;
            l2 = l2.next;
        }

        if(carry > 0){
            sum.next = new ListNode(carry);
        }

        ListNode ans = reverseList(dummy.next);

        return ans;
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
