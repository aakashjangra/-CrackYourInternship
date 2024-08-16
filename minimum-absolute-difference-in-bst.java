// Problem link - https://leetcode.com/problems/minimum-absolute-difference-in-bst/

// TC - O(n)
// SC - O(1)
class Solution {
    int prev = 100001; // 10 ^ 5 + 1
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return Integer.MAX_VALUE;

        int left = getMinimumDifference(root.left);
        int absDiff = Math.abs(root.val - prev);
        prev = root.val;
        int right = getMinimumDifference(root.right);

        if(left < absDiff) absDiff = left;
        if(right < absDiff) absDiff = right;

        return absDiff;
    }
}
