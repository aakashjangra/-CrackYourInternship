// Problem link - https://www.geeksforgeeks.org/problems/binary-tree-to-dll/1

// TC - O(N)
// SC - O(H)
class Solution
{
    Node prev;
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
        prev = null;
        
        return inorder(root);
    }
    Node inorder(Node root){
        if(root == null) return null;
        
        Node oldLeft = root.left;
        Node oldRight = root.right;
        
        Node smallest = inorder(oldLeft);
        
        if(prev != null){
            prev.right = root;
            root.left = prev;
        }
        
        prev = root;
        
        inorder(oldRight);
        
        return smallest != null? smallest: root;
    }
}
