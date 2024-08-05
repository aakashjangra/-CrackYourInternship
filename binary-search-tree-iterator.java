// Problem link - https://leetcode.com/problems/binary-search-tree-iterator/

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

// TC - O(n)
// SC - O(n)
class BSTIterator {
    TreeNode node;
    TreeNode prev;
    public BSTIterator(TreeNode root) {
        node = new TreeNode(-1);
        prev = node;

        inorder(root);
    }

    private void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);

        prev.right = root;

        prev = root;

        inorder(root.right);
    }
    
    public int next() {
        node = node.right;
        return node.val;
    }
    
    public boolean hasNext() {
        return (node != null && node.right != null);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
