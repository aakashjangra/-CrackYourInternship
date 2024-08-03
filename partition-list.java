// Problem link - https://leetcode.com/problems/partition-list/

// TC - O(n)
// SC - O(1)
class Solution {
    public ListNode partition(ListNode head, int x) {
        
        ListNode dummySmaller = new ListNode(-1);
        ListNode dummyEqualOrHigher = new ListNode(-1);

        ListNode smaller = dummySmaller, biggerOrEqual = dummyEqualOrHigher;
        // separater lists
        while(head != null){
            if(head.val < x){
                smaller.next = head;
                smaller = head;
            } else {
                biggerOrEqual.next = head;
                biggerOrEqual = head;
            }

            head = head.next;
        }

        // merge and return
        smaller.next = dummyEqualOrHigher.next;
        biggerOrEqual.next = null;

        return dummySmaller.next;
    }
}
