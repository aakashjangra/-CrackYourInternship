// Problem link - https://www.geeksforgeeks.org/problems/partition-array-to-k-subsets/1

class Solution
{
    public boolean isKPartitionPossible(int nums[], int n, int k)
    {
        int totalSum = Arrays.stream(nums).sum();
        
        if(totalSum % k != 0) return false;
        
        int targetSum = totalSum / k;
        
        Arrays.sort(nums);
        
        return helper(nums, n - 1, k, 0, targetSum, new boolean[n]);
    }
    
    private boolean helper(int[] nums, int index, int k, int currentSum, int targetSum, boolean[] vis){
        if(k == 0) return true;
        
        if(currentSum == targetSum){
            return helper(nums, nums.length - 1, k - 1, 0, targetSum, vis);
        }
        
        for(int i = index; i >= 0; i--){
            if(vis[i]) continue;
            
            if(i + 1 < nums.length && nums[i] == nums[i + 1] && !vis[i + 1]){
                continue;
            }
            
            if(currentSum + nums[i] <= targetSum){
                vis[i] = true;
                
                if(helper(nums, i - 1, k, currentSum + nums[i], targetSum, vis)){
                    return true;
                }
                
                vis[i] = false;
            }
        }
        
        return false;
    }
}
