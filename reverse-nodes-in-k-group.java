// Problem link - https://leetcode.com/problems/reverse-nodes-in-k-group/

// TC - O(n * k)
// SC - O(1)
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;
        // reverse k group and send ahead
        ListNode kth = head;
        int pos = 1;

        while(pos < k && kth.next != null){
            pos++;
            kth = kth.next;
        }

        ListNode nextHead = kth.next;
        kth.next = null;
        
        // if less nodes than k, it remains same, so return head
        if(pos < k){
            return head;
        }

        ListNode remaining = reverseKGroup(nextHead, k);

        // if k or more than k, reverse these k and attach remaining after reversing them in k groups
        ListNode newHead = reverseLL(head);
        head.next = remaining;

        return newHead;
    }

    public ListNode reverseLL(ListNode head){
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
