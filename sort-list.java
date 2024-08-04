// Problem link - https://leetcode.com/problems/sort-list/

// TC - O(n log n)
// SC - O(1)
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        //split into two
        ListNode prev = null, slow = head, fast = head;
      
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode ans = new ListNode(0);
        ListNode dummy = ans;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }

        if(l1 != null){
            dummy.next = l1;
        } else if(l2 != null){
            dummy.next = l2;
        }

        return ans.next;
    }
}
