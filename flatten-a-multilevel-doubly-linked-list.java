// Problem link - https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

// TC - O(n * n)
// SC - O(1)

class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;

        Node ptr = head;

        while(ptr != null){
            Node nextNode = ptr.next;
            if(ptr.child != null){
                Node childNode = flatten(ptr.child);
                childNode.prev = ptr;

                ptr.next = childNode;
                ptr.child = null;

                Node childLastNode = lastNode(childNode);
                childLastNode.next = nextNode;
                if(nextNode != null){
                    nextNode.prev = childLastNode;
                }
                childLastNode.child = null;
            }

            ptr = nextNode;
        }
        

        return head;
    }

    private Node lastNode(Node head){
        Node last = head;

        while(last != null && last.next != null){
            last = last.next;
        }

        return last;
    }
}
