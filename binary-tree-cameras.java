// Problem link - https://leetcode.com/problems/binary-tree-cameras/

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
    int cameras;
    public int minCameraCover(TreeNode root) {
        cameras = 0;
        int val = installCamera(root);

        return cameras + (val == 0? 1: 0);
    }
    // 0 means that node is not covered
    private int installCamera(TreeNode root){
        if(root == null) return 2;

        int left = installCamera(root.left);
        int right = installCamera(root.right);
        if(left == 0 || right == 0){
            cameras++;
            return 1;
        }
        return (left == 1 || right == 1? 2: 0);
    }
}
