// Problem link - https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

// TC - O(N)
// SC - O(log N)
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeBST(0, nums.length - 1, nums);
    }

    private TreeNode makeBST(int s, int e, int[] nums){
        if(s == e) return new TreeNode(nums[s]);
        if(s > e) return null;

        int mid = (s + e)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = makeBST(s, mid - 1, nums);
        root.right = makeBST(mid + 1, e, nums);

        return root;
    }
}
