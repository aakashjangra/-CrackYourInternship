// Problem link - https://www.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/1

// TC - O(N)
// SC - O(H)
class Solution
{
    //Function to count number of nodes in BST that lie in the given range.
    int getCount(Node root,int l, int h)
    {
        if(root == null) return 0;
        
        int left = 0;
        if(l < root.data){
            left = getCount(root.left, l, h);
        }
        int right = 0;
        if(root.data < h){
            right = getCount(root.right, l, h);
        }
        
        int cur = (l <= root.data && root.data <= h)? 1: 0;
        
        return left + cur + right;
    }
}
