// Problem link - https://leetcode.com/problems/balanced-binary-tree/

// TC - O(N)
// SC - O(1)
class Solution {
    public boolean isBalanced(TreeNode root) {
        int[] res = helper(root);
        if(res[0] == 0) return false;
        return true;
    }

    // int[] - > {isBalanced, depth}
    private int[] helper(TreeNode root){
        if(root == null) return new int[]{1, 0};

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        //if any subtree is unbalanced, return unbalanced
        if(left[0] == 0 || right[0] == 0) return new int[]{0, Math.max(left[1], right[1]) + 1};

        if(Math.abs(left[1] - right[1]) >= 2){
            //depth diff > 2, return unbalanced
            return new int[]{0, Math.max(left[1], right[1]) + 1};
        }

        return new int[]{1, Math.max(left[1], right[1]) + 1};
    }
}
