// Problem link - https://leetcode.com/problems/super-egg-drop/

class Solution {
    Integer[][] dp;
    public int superEggDrop(int k, int n) {
        dp = new Integer[k + 1][n + 1];

        return helper(k, n);
    }
    private int helper(int k, int n){
        if(n == 0 || n == 1 || k == 1) return n;

        if(dp[k][n] != null) return dp[k][n];

        int min = Integer.MAX_VALUE;
        int l = 1, r = n;
        while(l <= r){
            int mid = (l + r)/2;

            int breakCount, noBreakCount;

            
            breakCount = helper(k - 1, mid - 1);
            noBreakCount = helper(k, n - mid);

            int temp = 1 + Math.max(breakCount, noBreakCount);

            if(breakCount > noBreakCount){
                r = mid - 1;
            } else {
                l = mid + 1;
            }

            min = Math.min(temp, min);
        }

        return dp[k][n] = min;
    }
}
