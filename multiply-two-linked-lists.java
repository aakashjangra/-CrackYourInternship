// Problem link - https://www.geeksforgeeks.org/problems/multiply-two-linked-lists/1

// TC - O(n)
// SC - O(1)
class Solution {
    public long multiplyTwoLists(Node first, Node second) {
        long m = (long)(1e9) + 7;
        long n1 = 0, n2 = 0;
        
        Node temp = first;
        while(temp != null){
            n1 = (n1 * 10) % m + temp.data;
            temp = temp.next;
        }
        temp = second;
        while(temp != null){
            n2 = (n2 * 10) % m + temp.data;
            temp = temp.next;
        }
        
        return (n1 * n2) % m;
    }
}
