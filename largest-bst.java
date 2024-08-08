// Problem link - https://www.geeksforgeeks.org/problems/largest-bst/1

// TC - O(n)
// SC - O(n) - recursion stack space
class Solution{
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        
        Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root)
    {
        return helper(root).size;
    }
    
    static Info helper(Node root){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        Info leftInfo = helper(root.left);
        Info rightInfo = helper(root.right);
        
        if(leftInfo.isBST && rightInfo.isBST && leftInfo.max < root.data && root.data < rightInfo.min){
            int size = leftInfo.size + rightInfo.size + 1;
            int min = Math.min(root.data, leftInfo.min);
            int max = Math.max(root.data, rightInfo.max);
            return new Info(true, size, min, max);
        } else 
        {
            int size = Math.max(leftInfo.size, rightInfo.size);
            return new Info(false, size, 0, 0);
        }
    }
}
