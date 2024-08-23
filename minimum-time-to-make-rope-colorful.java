// Problem link - https://leetcode.com/problems/minimum-time-to-make-rope-colorful/

// TC - O(N)
// SC - O(1)
class Solution {
    public int minCost(String colors, int[] neededTime) {

        int n = colors.length();
//edge case
        if(n == 1) return 0;

        char prev = colors.charAt(0);
        int totalTime = neededTime[0];
        int savedTime = neededTime[0];
        int timeNotConsumed = 0;

        for(int i = 1; i<n; i++){
            //have to see upto which they are same and get the maximum out of same
            //if not same then add them in timeNotConsumed
            if(prev != colors.charAt(i)){
               timeNotConsumed += savedTime;
               savedTime = neededTime[i];
            } else {
               savedTime = Math.max(savedTime, neededTime[i]);
            }

            prev = colors.charAt(i);
            
            totalTime += neededTime[i];
        }

        timeNotConsumed += savedTime;

        return totalTime-timeNotConsumed;
    }
}
