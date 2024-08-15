// Problem link - https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

// TC - O(n)
// SC - O(n)
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //using " " - whitespace as delimiter
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null) {
                sb.append("X ");
                continue;
            }
            sb.append(node.val + " ");
            q.offer(node.left);
            q.offer(node.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] arr = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);

        for(int i = 1; i < arr.length; i += 2){
            TreeNode parent = q.poll();
            if(!arr[i].equals("X")){
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                parent.left = left;
                q.offer(left);
            } 
            if(!arr[i + 1].equals("X")){
                TreeNode right = new TreeNode(Integer.parseInt(arr[i + 1]));
                parent.right = right;
                q.offer(right);
            }

        }
        return root;
    }
}
