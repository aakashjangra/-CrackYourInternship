// Problem link - https://leetcode.com/problems/same-tree/

// TC - O(N)
// SC - O(1)
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        //both are not null, because of upper condition
        //check is one is null, that means other is not null
        if(p == null || q == null) return false;   

        if(p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
