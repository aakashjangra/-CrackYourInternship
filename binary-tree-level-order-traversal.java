// Problem link - https://leetcode.com/problems/binary-tree-level-order-traversal/

// TC - O(n)
// SC - O(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> thisLevel = new ArrayList<>();
            while(size-- > 0){
                TreeNode cur = q.poll();

                thisLevel.add(cur.val);

                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }

            ans.add(thisLevel);
        }

        return ans;
    }
}
