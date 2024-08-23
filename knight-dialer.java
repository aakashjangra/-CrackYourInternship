// Problem link - https://leetcode.com/problems/knight-dialer/

class Solution {
    int MOD = 1_000_000_007;
    long[][][] dp;
    public long numbers(int i, int j, int jumps){
        if(i < 0 || j < 0 || i >= 4 || j >= 3 || (i == 3 && j != 1)) return 0;

        if(jumps == 1) return 1;

        if(dp[i][j][jumps] > 0) return dp[i][j][jumps];

        //we have to make the choices and then return the sum of their results
        
        dp[i][j][jumps] = numbers(i+2, j-1, jumps-1)%MOD 
                        + numbers(i+2, j+1, jumps-1)%MOD 
                        + numbers(i-2, j-1, jumps-1)%MOD 
                        + numbers(i-2, j+1, jumps-1)%MOD 
                        + numbers(i+1, j+2, jumps-1)%MOD 
                        + numbers(i-1, j+2, jumps-1)%MOD 
                        + numbers(i+1, j-2, jumps-1)%MOD 
                        + numbers(i-1, j-2, jumps-1)%MOD ;
                        

        return dp[i][j][jumps];
    }
    public int knightDialer(int n) {
        
        dp = new long[4][3][n+1];
        long validNumbers = 0;
        for(int i = 0; i<4; i++){
            for(int j = 0; j<3; j++){
                if(i != 3 || j == 1){
                    validNumbers = (validNumbers%MOD + numbers(i, j, n))%MOD;
                }
            }
        }

        return (int)(validNumbers%MOD);
    }
}
