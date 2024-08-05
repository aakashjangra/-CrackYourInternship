// Problem link - https://www.geeksforgeeks.org/problems/word-wrap1646/1

// TC - O(n * k)
// SC - O(n * k)
class Solution
{
    Integer[][] memo;
    public int solveWordWrap (int[] nums, int k)
    {
        memo = new Integer[k + 2][nums.length];
        return helper(nums, k, 0, k);
    }
    
    private int helper(int[] nums, int remainingSpace, int i, int k){
        if(i >= nums.length) return 0;
        
        if(memo[remainingSpace + 1][i] != null) return memo[remainingSpace + 1][i];
        
        int ans;
        
        int rem = remainingSpace + 1;
        if(remainingSpace - nums[i] < 0){
            
            ans = (rem * rem) + helper(nums, k - nums[i] - 1, i + 1, k);
        } else {
            int take = (rem * rem) + helper(nums, k - nums[i] - 1, i + 1, k);
            int notTake = helper(nums, remainingSpace - nums[i] - 1, i + 1, k);
            ans = Math.min(take, notTake);
        }
        
        return memo[remainingSpace + 1][i] = ans;
    }
}
