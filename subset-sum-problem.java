//Problem link - https://www.geeksforgeeks.org/problems/subset-sum-problem2014/1

// TC - O(n * t)
// SC - O(t), t = sum of elements of nums / 2
class Solution{
    static int equalPartition(int n, int nums[])
    {
        int total = 0;
        for(int val: nums) total += val;
        
        if(total % 2 == 1){
            //odd total, can't partition
            return 0;
        }
        
        int targetSum = total/2; // for each partition out of 2 partitions
        
        int[] dp = new int[targetSum + 1];
        dp[0] = 1; // sum 0 is achievable
        
        for(int num: nums){
            HashSet<Integer> achievedSums = new HashSet<>();
            
            for(int j = num; j <= targetSum; j++){
                if(dp[j] == 0 && dp[j - num] == 1 && !achievedSums.contains(j - num))
   {
       dp[j] = 1;
       achievedSums.add(j);
   }         }
        }
        
        if(dp[targetSum] == 1){
            return 1;
        }
        
        return 0;
        
    }
}
