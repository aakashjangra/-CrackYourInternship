// Problem link - https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

// TC - O(N)
// SC - O(1)
class Solution {
    public int getDecimalValue(ListNode head) {
        int num = 0;

        while(head != null){
            if(head.val == 1){
                num = (num * 2) + 1;
            } else {
                num = (num * 2);
            }

            head = head.next;
        }

        return num;
    }
}
