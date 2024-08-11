// Problem link - https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

// TC - O(n)
// SC - O(n)
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean dirLeft = false;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> thisLevel = new ArrayList<>();
            // one level
            while(size-- > 0){
                TreeNode cur = q.poll();

                thisLevel.add(cur.val);

                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }

            if(dirLeft){
                Collections.reverse(thisLevel);
            }
            ans.add(thisLevel);
            dirLeft = !dirLeft;
        }

        return ans;
    }
}
