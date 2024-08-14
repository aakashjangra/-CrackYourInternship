// Problem link - https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

// TC - O(n)
// SC - O(n)
class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                Node cur = q.poll();
                
                if(size > 1){
                    //has a node to it's left in this level
                    cur.next = q.peek();
                }

                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);

                size--;
            }
        }

        return root;
    }
}
