// Problem link - https://leetcode.com/problems/copy-list-with-random-pointer/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

// TC - O(n)
// SC - O(n)
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        HashMap<Node, Node> oldToNew = new HashMap<>();
        oldToNew.put(null, null);
        
        Node ptr = head;
        while(ptr != null){
            Node copy = new Node(ptr.val);
            oldToNew.put(ptr, copy);
            
            ptr = ptr.next;
        }
        
        ptr = head;
        while(ptr != null){
            Node cur = oldToNew.get(ptr);
            cur.next = oldToNew.get(ptr.next);
            cur.random = oldToNew.get(ptr.random);
            
            ptr = ptr.next;
        }
        
        return oldToNew.get(head);
    }
}
