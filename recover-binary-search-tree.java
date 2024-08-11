// Problem link - https://leetcode.com/problems/recover-binary-search-tree/

// TC - O(N)
// SC - O(N)
class Solution {
    List<Integer> values;
    int index;
    public void recoverTree(TreeNode root) {
        values = new ArrayList<>();

        inorder(root); //values should be in ascending order, other than those which are swapped

        Collections.sort(values); // sort in ascending order

        index = 0;

        putCorrectValues(root);
    }
    private void putCorrectValues(TreeNode root){
        if(root == null) return;

        putCorrectValues(root.left);

        root.val = values.get(index);
        index++;

        putCorrectValues(root.right);
    }
    private void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);

        values.add(root.val);

        inorder(root.right);
    }
}
