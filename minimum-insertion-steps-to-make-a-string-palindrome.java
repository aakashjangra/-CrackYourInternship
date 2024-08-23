// Problem link - https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/

// TC - O(N * N)
// SC - O(N * N)
class Solution {
    public int minInsertions(String s) {
        // longest palindromic subsequence, let it be x
        // n - x is our answer

        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String rev = sb.toString();

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(s.charAt(i - 1) == rev.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return n - dp[n][n];
    }
}
