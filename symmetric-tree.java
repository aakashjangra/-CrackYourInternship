// Problem link - https://leetcode.com/problems/symmetric-tree/

// TC _ O(N)
// SC _ O(1)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode first, TreeNode second){
        if(first == null && second == null){
            return true;
        }

        if((first == null && second != null) || (first != null && second == null)){
            return false;
        }

        boolean flag = true;
        if(first.val != second.val){
            flag = false;
        }

        return flag && helper(first.left, second.right) && helper(first.right, second.left);
    }
}
