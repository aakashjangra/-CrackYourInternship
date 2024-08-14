// Problem link - https://leetcode.com/problems/sum-of-left-leaves/

// TC - O(n)
// SC - O(1)
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;

        int left = sumOfLeftLeaves(root.left);
        int right = sumOfLeftLeaves(root.right);

        int total = left + right;

        //check if left child is a leaf node, if yes, add to sum
        if(root.left != null && root.left.left == null && root.left.right == null){
            total += root.left.val;
        }

        return total;
    }
}
