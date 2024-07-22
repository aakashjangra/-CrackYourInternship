//Problem link - https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

//Approach 1 - using extra space
class Solution {
    public void flatten(TreeNode root) { 
        if(root == null) return;

        List<TreeNode> preorder = new ArrayList<>();

        getPreorder(root, preorder);

        for(int i = 0; i < preorder.size() - 1; i++){
            TreeNode cur = preorder.get(i), next = preorder.get(i + 1);

            cur.left = null;
            cur.right = next;

            next.left = null;
        }
    }
    private void getPreorder(TreeNode root, List<TreeNode> preorder){
        if(root == null) return ;

        preorder.add(root);

        getPreorder(root.left, preorder);
        getPreorder(root.right, preorder);
    }
}

//Approach 2 - using constant space
class Solution {
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;

        prev = root;
    }
}
