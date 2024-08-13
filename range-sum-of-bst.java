// Problem link - https://leetcode.com/problems/range-sum-of-bst/

// TC - O(n)
// SC - O(1)
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;

        int left = 0, right = 0;

        int sum = 0;

        if(low <= root.val && root.val <= high){
            sum += root.val;
            left = rangeSumBST(root.left, low, high);
            right = rangeSumBST(root.right, low, high);
        } else if(root.val < low){
            right = rangeSumBST(root.right, low, high);
        } else if (high < root.val){
            left = rangeSumBST(root.left, low, high);
        }

        sum = left + right + sum;

        return sum;
    }
}
