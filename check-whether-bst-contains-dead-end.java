// Problem link - https://www.geeksforgeeks.org/problems/check-whether-bst-contains-dead-end/1

// TC - O(n)
// SC - O(h) - recursive stack space
class Solution
{
    public static boolean isDeadEnd(Node root)
    {
        return helper(1, 1001, root);
    }
    
    private static boolean helper(int min, int max, Node root){
        if(root == null) return false;
        
        //if leaf, check if dead end
        if(root.left == null && root.right == null){
            return (min == root.data && root.data == max);
        }
        
        boolean left = helper(min, root.data - 1, root.left);
        boolean right = helper(root.data + 1, max, root.right);
        
        return (left || right);
    }
}
