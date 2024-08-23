// Problem link - https://leetcode.com/problems/binary-tree-paths/

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();

        helper(root, new StringBuilder(), ans);

        return ans;
    }
    private void helper(TreeNode root, StringBuilder sb, List<String> ans){
        if(root == null) return;

        if(root.left == null && root.right == null){
            //leaf node
            sb.append(Integer.toString(root.val));
            ans.add(sb.toString());
        }

        //root
        sb.append(Integer.toString(root.val));

        if(root.left != null){
            StringBuilder temp = new StringBuilder(sb);
            temp.append("->");
            helper(root.left, temp, ans);
        }

        if(root.right != null){
            StringBuilder temp = new StringBuilder(sb);
            temp.append("->");
            helper(root.right, temp, ans);
        }
    }
}
