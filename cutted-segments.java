// Problem link - https://www.geeksforgeeks.org/problems/cutted-segments1642/1

// TC - O(N)
// SC - O(N)
class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
        
        // it will store the max count of segments at each point
       int[] dp = new int[n+1];
       dp[n] = 1;
       
       for(int i = n - 1; i >= 0; i--){
           int max = 0;
           if(i + x <= n && dp[i + x] > 0){
               max = dp[i + x] + 1;
           }
           if(i + y <= n && dp[i + y] > 0){
               max = Math.max(dp[i + y] + 1, max);
           }
           if(i + z <= n && dp[i + z] > 0){
               max = Math.max(dp[i + z] + 1, max);
           }
           
           dp[i] = max;
       }
       
       return (dp[0] > 0? dp[0] - 1: 0);
    }
}
