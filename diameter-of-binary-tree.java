// Problem link - https://leetcode.com/problems/diameter-of-binary-tree/

// TC - O(n)
// SC - O(1)
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root)[0];
    }

    //int[] -> {maxDiameter, maxDepth}
    public int[] helper(TreeNode root){
        if(root == null) return new int[]{0, 0};

        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int maxDiameter = Math.max(Math.max(left[0], right[0]), left[1] + right[1]);

        return new int[]{maxDiameter, Math.max(left[1], right[1]) + 1};
    }
}
