// Problem link - https://www.geeksforgeeks.org/problems/k-sum-paths/1

// TC - O(N)
// SC - O(N)
class Solution {
    HashMap<Integer, Integer> map;
    
    public int sumK(Node root, int k) {
        if(root == null) return 0;
        
        map = new HashMap<>();
        map.put(0, 1);
        
        return helper(root, 0, k);
    }
    
    private int helper(Node root, int sum, int k){
        if(root == null) return 0;
        //preorder traversal, so flow is downward only
        int count = 0;
        sum += root.data;
        if(map.containsKey(sum - k)){
            count += map.get(sum - k);
        }
        
        if(map.containsKey(sum)){
            map.put(sum, map.get(sum) + 1);
        } else {
            map.put(sum, 1);
        }
        
        count += helper(root.left, sum, k);
        count += helper(root.right, sum, k);
        
        // update map, remove root state
        map.put(sum, map.get(sum) - 1);
        
        return count;
    }
}
