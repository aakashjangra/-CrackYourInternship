// Problem link - https://leetcode.com/problems/trapping-rain-water/

// TC - O(n)
// SC - O(n)

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMaxHeight = 0;
        int[] rightMaxHeight = new int[n];
        
        //making rightMaxHeight array
        for(int i = n - 2; i >= 0; i--){
            rightMaxHeight[i] = Math.max(rightMaxHeight[i + 1], height[i + 1]);
        }
        
        //finding answer
        int totalTrappedWater = 0;
        
        for(int i = 1; i < n; i++){
            leftMaxHeight = Math.max(leftMaxHeight, height[i - 1]);
            
            // will calculate water at every point and add it to totalTrappedWater
            int waterAtThisCell = Math.min(leftMaxHeight, rightMaxHeight[i]) - height[i];
            
            if(waterAtThisCell > 0){
                totalTrappedWater += waterAtThisCell;
            }
        }
        
        return totalTrappedWater;
    }
}
