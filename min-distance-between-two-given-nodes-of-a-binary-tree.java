// Problem link - https://www.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1

// TC - O(n)
// SC - O(H)

class GfG {
    int findDist(Node root, int a, int b) {
        Node lca = findLCA(root, a, b);
        
        int distA = findHeight(lca, a);
        int distB = findHeight(lca, b);
        
        return distA + distB - 2;
    }
    
    Node findLCA(Node root, int a, int b){
        if(root == null || root.data == a || root.data == b) return root;
        
        Node left = findLCA(root.left, a, b);
        Node right = findLCA(root.right, a, b);
        
        if(left == null) return right;
        
        if(right == null) return left;
        
        return root;
    }
    
    int findHeight(Node root, int target){
        if(root == null) return 0;
        if(root.data == target) return 1;
        
        int left = findHeight(root.left, target);
        int right = findHeight(root.right, target);
        
        if(left != 0){
            return left + 1;
        } 
        if(right != 0){
            return right + 1;
        }
        
        return 0;
    }
}
