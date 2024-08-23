// Problem link - https://leetcode.com/problems/minimum-cost-to-merge-stones/

// SC - O(N * N)
class Solution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if(((n - 1) % (k - 1)) != 0){
            return -1;
        }

        int[] prefixSum = new int[n + 1];
        for(int i = 0; i < n; i++){
            prefixSum[i + 1] = prefixSum[i] + stones[i];
        }

        int[][] dp = new int[n][n];
        for(int len = k; len <= n; len++){  
            for(int i = 0; i + len <= n; i++){  
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int m = i; m < j; m += k - 1){  
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                }
                if(((len - 1) % (k - 1)) == 0){
                    dp[i][j] += prefixSum[j + 1] - prefixSum[i];
                }
            }
        }

        return dp[0][n - 1];
    }
}
