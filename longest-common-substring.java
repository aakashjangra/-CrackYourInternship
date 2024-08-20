// Problem link - https://www.geeksforgeeks.org/problems/longest-common-substring1452/1

// TC - O(N * M)
// SC - O(N * M)
class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        int longest = 0;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                
                longest = Math.max(dp[i][j], longest);
            }
        }
        
        return longest;
    }
}
