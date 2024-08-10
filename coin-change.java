// Problem link - https://leetcode.com/problems/coin-change/

// TC - O(n * amount)
// SC - O(amount)
class Solution {
    public int coinChange(int[] coins, int amount) {
        //via TABULATION 
        int[] memo = new int[amount+1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        int originalAmount = amount;

        // int minCoins = tryCombinations(amount, coins, memo);
        for(int val = 1; val <= originalAmount; val++){
            int minCoins = Integer.MAX_VALUE;

            for(int i = 0; i<coins.length; i++){
                if((val - coins[i] >= 0) && memo[val-coins[i]] != -1){
                    int res = memo[val-coins[i]];
                    minCoins = Math.min(minCoins, res);
                }
            }

            memo[val] = (minCoins == Integer.MAX_VALUE? minCoins: minCoins+1);
        }

        return memo[originalAmount] == Integer.MAX_VALUE? -1: memo[originalAmount];
    }
}
