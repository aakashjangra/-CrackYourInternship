// Problem link - https://leetcode.com/problems/add-two-numbers/

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

//m is the length of l1 and n is the size of l2
// TC - O(max(m, n))
// SC - O(max(m, n))
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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

        return dummy.next;
    }
}
