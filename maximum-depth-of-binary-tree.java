// Problem link - https://leetcode.com/problems/maximum-depth-of-binary-tree/

// TC - O(n)
// SC - O(n)
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;

        while(!q.isEmpty()){
            depth++;
            int size = q.size();

            while(size-- > 0){
                TreeNode cur = q.poll();

                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
        }

        return depth;
    }
}
