// Problem link - https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1

// TC - O(N log N)
// SC - O(1)
class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // sorting + sliding window
        Collections.sort(a);
        
        int i = 0, j = 0;
        int minDiff = Integer.MAX_VALUE;
        
        while(j < n){
            
            if(j - i + 1 == m){
                int diff = a.get(j) - a.get(i);
                minDiff = Math.min(diff, minDiff);
                i++;
            }
            
            j++;
        }
        
        return minDiff;
    }
}
