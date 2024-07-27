// Problem link - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

// TC - O(n)
// SC - O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int boughtAt = prices[0];
        int totalProfit = 0;
        int n = prices.length;

        for(int i = 0; i < n - 1; i++){
            // peak price, dip ahead
            if(boughtAt <= prices[i] && prices[i] > prices[i + 1]){
                // sell it today
                totalProfit += prices[i] - boughtAt;

                boughtAt = prices[i + 1];
            }
        }

        if(boughtAt < prices[n - 1]){
            totalProfit += prices[n - 1] - boughtAt;
        }

        return totalProfit;
    }
}
