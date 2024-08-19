// Problem link - https://leetcode.com/problems/binary-tree-maximum-path-sum/

// TC - O(N)
// SC - O(H)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = root.val;

        helper(root);
        return maxSum;
    }

    //max depth sum will be returned from each node
    private int helper(TreeNode root){
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        int curSum = left + root.val + right;

        left += root.val;
        right += root.val;

        maxSum = Math.max(maxSum, curSum);
        if(root.left != null && left > maxSum) maxSum = left;
        if(root.right != null && right > maxSum) maxSum = right;
        if(root.val > maxSum) {
            maxSum = root.val;
        }

        return Math.max(root.val, Math.max(left, right));
    }
}
