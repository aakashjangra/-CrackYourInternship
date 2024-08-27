//Problem link - https://leetcode.com/problems/count-different-palindromic-subsequences/

// TC - O(n * n)
// SC - O(n * n)
class Solution {
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        int mod = (int)(1e9) + 7;

        int[][][] dp = new int[n + 1][n + 1][5];

        for(int i = 1; i <= n; i++){
            dp[i][i][s.charAt(i - 1) - 'a']++;
            dp[i][i][4] = 1;

            for(int j = i - 1; j >= 1; j--){
                for(int k = 0; k < 4; k++){
                    int codeI = s.charAt(i - 1) - 'a';
                    int codeJ = s.charAt(j - 1) - 'a';
                    if(codeI == k && codeJ == k){
                        dp[i][j][k] = (dp[i - 1][j + 1][4] + 2) % mod;
                        dp[i][j][4] = (dp[i][j][4] + dp[i][j][k]) % mod;
                    } else if(codeI == k){
                        dp[i][j][k] = dp[i][j + 1][k];
                        dp[i][j][4] = (dp[i][j][4] + dp[i][j][k]) % mod;
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                        dp[i][j][4] = (dp[i][j][4] + dp[i][j][k]) % mod;
                    }
                }
            }
        }

        return dp[n][1][4];
    }
}
