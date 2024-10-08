// Problem link - https://leetcode.com/problems/distinct-subsequences/

// TC - O(N*M)
// SC - O(N*M)
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int dp[][] = new int[n + 1][m + 1];

        //initialization
        for(int i = 0; i <= n; i++){
            dp[i][m] = 1;
        }

        //making ans
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        return dp[0][0];
    }
}
