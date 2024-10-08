// Problem link - https://www.geeksforgeeks.org/problems/preorder-to-postorder4423/1

// TC - O(n)
// SC - O(1)
static class Solution {
    // Function that constructs BST from its preorder traversal.
    public Node Bst(int pre[], int size) {
        return bst(pre, Integer.MAX_VALUE, new int[]{0});
    }
    private Node bst(int pre[], int bound, int[]i){
        if(i[0] == pre.length || pre[i[0]] > bound){
            return null;
        }
        
        Node root = new Node(pre[i[0]++]);
        root.left = bst(pre, root.data, i);
        root.right = bst(pre, bound, i);
        return root;
    }
}
