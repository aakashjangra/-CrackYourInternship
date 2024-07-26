// Problem link - https://www.geeksforgeeks.org/problems/delete-nodes-having-greater-value-on-right/1

// TC - O(n)
// SC - O(n) - recursion stack space
class Solution
{
    Node compute(Node head)
    {
        if(head.next == null) return head;
        
        Node ahead = compute(head.next);
        
        if(ahead.data > head.data){
            //remove current node - head
            return ahead;
        }
        
        head.next = ahead;
        return head;
    }
}
