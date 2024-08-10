// Problem link - https://leetcode.com/problems/ones-and-zeroes/

// l is the length of strs[]
// TC - O(l ^ 2)
// SC - O(l * m * n)
class Solution {
    Integer[][][] memo;
    public int findMaxForm(String[] strs, int m, int n) {
        memo = new Integer[strs.length][m + 1][n + 1];
        return helper(0, m, n, strs);
    }

    private int helper(int pos, int m, int n, String[] strs){
        if(pos == strs.length) return 0;

        if(memo[pos][m][n] != null) return memo[pos][m][n];

        int countOfZero = countZero(strs[pos]);
        int countOfOne = strs[pos].length() - countOfZero;
        //take
        int taken = 0;
        
        if(countOfZero <= m && countOfOne <= n){
            taken = 1 + helper(pos + 1, m - countOfZero, n - countOfOne, strs); 
        }
        //not take
        int notTaken = helper(pos + 1, m, n, strs);

        return memo[pos][m][n] = Math.max(taken, notTaken);
    }

    private int countZero(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '0') count++;
        }
        return count;
    }
}
