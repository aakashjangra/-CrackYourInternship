// Problem link - https://leetcode.com/problems/kth-smallest-element-in-a-bst/

// TC - O(n)
// SC - O(n) - recursive stack space
class Solution {
    private int position;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;

        position = 1;
        int ans = helper(root, k);

        return ans;
    }

    private int helper(TreeNode root, int k){
        if(root == null) return -1;

        int left = helper(root.left, k);

        if(left >= 0) return left;

        if(position == k) return root.val;
        position++;

        int right = helper(root.right, k);

        return right;
    }
}
