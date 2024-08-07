// Problem link - https://leetcode.com/problems/maximum-width-of-binary-tree/

// TC - O(n)
// SC - O(n)
class Solution {
    class Node{
        TreeNode n;
        int index;
        Node(TreeNode _n, int i){
            this.n = _n;
            this.index = i;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        Queue<Node> q = new LinkedList<>();// level order traversal
        q.offer(new Node(root, 0));

        int maxWidth = 0;

        while(!q.isEmpty()){
            int size = q.size();
            int first = q.peek().index;
            int width = 0;
            while(size-- > 0){
                Node cur = q.poll();

                if(cur.n.left != null){
                    q.offer(new Node(cur.n.left, 2 * cur.index));
                }
                if(cur.n.right != null){
                    q.offer(new Node(cur.n.right, 2 * cur.index + 1));
                }

                if(size == 0){
                    //last node of this level
                    width = cur.index - first + 1;
                }
            }

            maxWidth = Math.max(maxWidth, width);
        }

        return maxWidth;
    }
}
