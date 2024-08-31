// Problem link - https://www.geeksforgeeks.org/problems/travelling-salesman-problem2732/1

class Solution {
    public int total_cost(int[][] cost) {
        int n = cost.length;
        return getMinCost(cost, new int[1 << n][n], n, 0, 1);
    }
    
    private int getMinCost(int[][] cost, int[][] dp, int n, int cur, int mask){
        if(mask == (1 << n) - 1){
            return cost[cur][0];
        }   
        
        if(dp[mask][cur] == 0){
            dp[mask][cur] = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                if((mask & (1 << i)) == 0){
                    dp[mask][cur] = Math.min(dp[mask][cur], cost[cur][i] + getMinCost(cost, dp, n, i, mask | 1 << i));
                }
            }
        }
        
        return dp[mask][cur];
    }
}
