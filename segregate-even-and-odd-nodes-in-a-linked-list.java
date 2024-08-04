// Problem link - https://www.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1

// TC - O(n)
// SC - O(1)
class Solution {
    Node divide(Node head) {
        Node evenDummy = new Node(-1);
        Node oddDummy= new Node(-1);
        
        Node ptrEven = evenDummy;
        Node ptrOdd = oddDummy;
        
        while(head != null){
            if(head.data % 2 == 0){
                //even
                ptrEven.next = head;
                ptrEven = head;
            } else {
                ptrOdd.next = head;
                ptrOdd = head;
            }
            
            head = head.next;
        }
        
        // link even and odd lists
        ptrEven.next = oddDummy.next;
        ptrOdd.next = null;
        
        return evenDummy.next;
    }
}
