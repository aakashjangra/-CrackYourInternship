// Problem link - https://leetcode.com/problems/path-sum-iii/

// TC - O(n)
// SC - O(n)
class Solution {
    HashMap<Long, Integer> map;
    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap<>();
        map.put((long)0, 1);
        return helper(root, 0, targetSum);
    }
    private int helper(TreeNode root, long sum, int k){
        if(root == null) return 0;

        int count = 0;
        sum += root.val;
        if(map.containsKey(sum - k)){
            count += map.get(sum - k);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        count += helper(root.left, sum, k) + helper(root.right, sum, k);

        if(map.get(sum) == 1){
            map.remove(sum);
        } else {
            map.put(sum, map.get(sum) - 1);
        }

        return count;
    }
}
