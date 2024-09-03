// Problem link - https://www.geeksforgeeks.org/minimize-cash-flow-among-given-set-friends-borrowed-money/

class Solution {
    public int[][] minCashFlow(int[][] transactions, int n) {
        int[] amount = new int[n];
        int[][] ans = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                amount[i] += (transactions[j][i] - transactions[i][j]);
            }
        }
        
        helper(amount, ans);
        return ans;
    }
    
    void helper(int[] amount, int[][] ans){
        int maxC = getMax(amount);
        int maxD = getMin(amount);
        if(amount[maxC] == 0 && amount[maxD] == 0){
            return;
        }
        int mini = Math.min(-amount[maxD], amount[maxC]);
        amount[maxC] -= mini;
        amount[maxD] += mini;
        ans[maxD][maxC] = mini;
        
        helper(amount, ans);
    }
    
    int getMin(int[] amount){
        int minIndex = 0;
        for(int i = 1; i < amount.length; i++){
            if(amount[i] < amount[minIndex]) minIndex = i;
        }
        
        return minIndex;
    }
    
    int getMax(int[] amount){
        int maxIndex = 0;
        for(int i = 1; i < amount.length; i++){
            if(amount[i] > amount[maxIndex]) maxIndex = i;
        }
        
        return maxIndex;
    }
}
