// Problem link - https://www.geeksforgeeks.org/problems/construct-tree-from-preorder-traversal/1

// TC - O(N)
// SC - O(1)
class Solution{
    int index = 0;
    Node constructTree(int n, int pre[], char preLN[]){
	    if(preLN[index] == 'L') return new Node(pre[index++]);
	    
	    Node root = new Node(pre[index]);
	    index++;
	    
	    root.left = constructTree(n, pre, preLN);
	    root.right = constructTree(n, pre, preLN);
	    
	    return root;
	}
}
