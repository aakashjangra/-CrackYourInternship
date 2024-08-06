// Problem link - https://leetcode.com/problems/binary-tree-right-side-view/

// TC - O(n)
// SC - O(n) 
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        // level order traversal, add the last node at each level to the ans
        q.offer(root);

        while(!q.isEmpty()){
            int levelSize = q.size();
            while(levelSize > 0){
                TreeNode cur = q.poll();

                if(levelSize == 1){
                    //last node
                    //add to ans
                    ans.add(cur.val);
                }

                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);

                levelSize--;
            }
        }

        return ans;
    }
}
