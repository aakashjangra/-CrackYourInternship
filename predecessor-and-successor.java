// Problem link - https://www.geeksforgeeks.org/problems/predecessor-and-successor/1


// TC - O(h)
// SC - O(h)
class Solution {
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key
        if(root == null) return;
        
        if(root.data == key) {
            if(root.left != null){
                Node temp = root.left;
                
                while(temp.right != null) temp = temp.right;
                
                pre[0] = temp;
            }
            
            if(root.right != null){
                Node temp = root.right;
                
                while(temp.left != null) temp = temp.left;
                
                suc[0] = temp;
            }
            
            return;
        }
        
        if(root.data > key){
            suc[0] = root;
            //finding smaller successor than root
            findPreSuc(root.left, pre, suc, key);
        } else {
            pre[0] = root;
            //find smaller predecessor if any
            findPreSuc(root.right, pre, suc, key);
        }
    }
}
