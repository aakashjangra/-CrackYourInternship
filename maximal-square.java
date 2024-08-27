// Problem link - https://leetcode.com/problems/maximal-square/

// TC - O(n * n * n)
// SC - O(n * m)
class Solution {
    public int maximalSquare(char[][] mat) {
        int n = mat.length, m = mat[0].length;

        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
                if(mat[i-1][j-1] == '1'){
                    dp[i][j]++;
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <= Math.min(n, m); i++){
            for(int j = 0 + i; j <= n; j++){
                for(int k = 0 + i; k <= m; k++){
                    int x = dp[j][k] - dp[j][k-i] - dp[j-i][k] + dp[j-i][k-i];

                    if(x == i*i){
                        ans = Math.max(ans, x);
                    }
                }
            }
        }

        return ans;
    }
}
