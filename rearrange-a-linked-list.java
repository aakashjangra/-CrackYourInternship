// Problem link - https://www.geeksforgeeks.org/problems/rearrange-a-linked-list/1

// TC - O(n)
// SC - O(1)
class Solution {

    // Should rearrange given linked list such that all even
    // positioned Nodes are before odd positioned.

    void rearrangeEvenOdd(Node head) {
        if(head == null || head.next == null || head.next.next == null) return;
        
        Node odd = head, even = head.next;
        Node evenPtr = even;
        
        while(odd.next != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        
        odd.next = evenPtr;
    }
}
