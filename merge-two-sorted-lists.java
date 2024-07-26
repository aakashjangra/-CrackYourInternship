// Problem link - https://leetcode.com/problems/merge-two-sorted-lists/description/

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

// n is the length of longer list
// TC - O(n)
// SC - O(1)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode sorted = new ListNode(-1);
        ListNode dummy = sorted;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                sorted.next = list1;

                list1 = list1.next;
            } else {
                sorted.next = list2;

                list2 = list2.next;
            }

            sorted = sorted.next;
        }

        while(list1 != null){
            sorted.next = list1;

            list1 = list1.next;
            sorted = sorted.next;
        }

        while(list2 != null){
            sorted.next = list2;

            list2 = list2.next;
            sorted = sorted.next;
        }

        return dummy.next;
    }
}
