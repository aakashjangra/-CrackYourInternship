// Problem link - https://leetcode.com/problems/merge-k-sorted-lists/

// TC - O(n log k)
// SC - O(k)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        for(ListNode node: lists){
            if(node != null){
                pq.offer(node);
            }
        }

        while(!pq.isEmpty()){
            ListNode node = pq.poll();

            dummy.next = node;
            dummy = node;

            if(node.next != null){
                pq.offer(node.next);
            }
        }

        return ans.next;
    }
}
