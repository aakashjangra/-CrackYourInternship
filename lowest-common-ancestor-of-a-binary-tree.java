// Problem link - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

// TC - O(n)
// SC - O(n) - recursive stack space
class Solution {
    TreeNode firstAncestor;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        firstAncestor = null;

        find(root, p, q);

        return firstAncestor;
    }

    // [] -> {foundP, foundQ}
    private boolean[] find(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return new boolean[]{false, false};

        boolean foundP = false, foundQ = false;
        if(root.val == p.val) {
            foundP = true;
        }
        if(root.val == q.val){
            foundQ = true;
        }

        boolean[] left = find(root.left, p, q);
        boolean[] right = find(root.right, p, q);

        foundP = (left[0] || right[0] || foundP);
        foundQ = (left[1] || right[1] || foundQ);

        if(foundP && foundQ && firstAncestor == null){
            firstAncestor = root;
        }

        return new boolean[]{foundP, foundQ};
    }
}
