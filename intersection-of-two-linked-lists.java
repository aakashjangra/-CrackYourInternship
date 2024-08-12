// Problem link - https://leetcode.com/problems/intersection-of-two-linked-lists/

// TC - O(m + n)
// SC - O(m)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> seen = new HashSet<>();
        while(headA != null){
            seen.add(headA);
            headA = headA.next;
        }

        while(headB != null){
            if(seen.contains(headB)) return headB;

            headB = headB.next;
        }

        return null;
    }
}
