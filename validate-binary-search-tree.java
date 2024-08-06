// Problem link - https://leetcode.com/problems/validate-binary-search-tree/

// TC - O(n)
// SC - O(n) - recursive stack space
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validateTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validateTree(TreeNode root, long min, long max){
        if(root == null) return true;

        boolean left = validateTree(root.left, min, (long)root.val - 1);
        boolean right = validateTree(root.right, (long)root.val + 1, max);

        if(!(min <= root.val && root.val <= max)) return false;

        return left && right;
    }
}
