// Problem link - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

// TC - O(2N * K)
// SC - O(2N * K)
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n + 1][2][k + 1];

        for(int index = n - 1; index >= 0; index--){
            for(int buy = 0; buy <= 1; buy++){
                for(int cap = 1; cap <= k; cap++){
                    if(buy == 0){
                        dp[index][buy][cap] = Math.max(0 + dp[index + 1][0][cap], -prices[index] + dp[index + 1][1][cap]);
                    }
                    if(buy == 1){
                        dp[index][buy][cap] = Math.max(0 + dp[index + 1][1][cap], prices[index] + dp[index + 1][0][cap - 1]);
                    }
                }
            }
        }

        return dp[0][0][k];
    }
}
