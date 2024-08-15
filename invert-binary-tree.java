// Problem link - https://leetcode.com/problems/invert-binary-tree/

// TC - O(n)
// SC - O(1)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

        invertTree(root.left);
        invertTree(root.right);

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;

        return root;
    }
}
