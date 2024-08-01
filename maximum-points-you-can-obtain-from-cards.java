// Problem link - https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/

// TC - O(n)
// SC - O(1)
class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int totalPoints = 0;
        int minPoints = Integer.MAX_VALUE;

        int i = 0, j = 0;
        int curPoints = 0;
        while(j < n)
        {
            curPoints += cardPoints[j];
            totalPoints += cardPoints[j];
            // length of subarray which we need to remove 
            if(j - i + 1 == (n - k)){
                minPoints = Math.min(minPoints, curPoints);

                curPoints -= cardPoints[i];
                i++;
            }
            j++;
        }

        if(n - k == 0){
            //we can take whole array
            return totalPoints;
        }

        return totalPoints - minPoints;
    }
}
