// Problem link - https://www.geeksforgeeks.org/minimum-cost-for-acquiring-all-coins-with-k-extra-coins-allowed-with-every-coin/

// TC - O(N log N)
// SC - O(1)
static int minCost(int coin[],  
                       int n, int k) 
    { 
          
        // sort the coins
        Arrays.sort(coin); 
  
        // no. of coins needed 
        int coins_needed = (int)Math.ceil(1.0 * 
                                  n / (k + 1)); 
  
        // sum of all selected coins 
        int ans = 0; 
          
        for (int i = 0; i <= coins_needed - 1;  
                                          i++) 
            ans += coin[i]; 
  
        return ans; 
    } 
