// Problem link - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/


// TC - O(n)
// SC - O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int maxValue = 0;

        for(int i = prices.length - 1; i >= 0; i--){
            ans = Math.max(ans, (maxValue - prices[i]));

            maxValue = Math.max(maxValue, prices[i]);
        }

        return ans;
    }
}
