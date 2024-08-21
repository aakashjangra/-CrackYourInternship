// Problem link - https://www.geeksforgeeks.org/problems/optimal-binary-search-tree2214/1

class Solution
{
    static Integer[][] memo;
    static int optimalSearchTree(int keys[], int freq[], int n)
    {
        memo = new Integer[n][n];
        return optimalCost(0, n - 1, freq);
    }
    
    static int optimalCost(int i, int j, int[] freq){
        if(j < i){
            return 0;
        }
        if(j == i){
            return freq[i];
        }
        
        if(memo[i][j] != null) return memo[i][j];
        
        // sum of frequecies, freq[i] + freq[i + 1] ... + freq[j]]
        int fSum = sum(i, j, freq);
        
        int min = Integer.MAX_VALUE; //min cost
        
        // making root one by one
        for(int r = i; r <= j; r++){
            int cost = optimalCost(i, r - 1, freq) + optimalCost(r + 1, j, freq);
            
            if(cost < min) min = cost;
        }
        
        return memo[i][j] = min + fSum;
    }
    
    static int sum(int i, int j, int[] freq){
        int total = 0;
        for(int k = i; k <= j; k++){
            total += freq[k];
        }
        return total;
    }
}
