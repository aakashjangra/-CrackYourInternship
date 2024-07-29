// Problem link - https://leetcode.com/problems/container-with-most-water/

// TC - O(n)
// SC - O(1)
class Solution {
    public int maxArea(int[] height) {
        int maximumArea = 0;

        int l = 0, r = height.length - 1;

        while(l < r){
            int area = Math.min(height[l], height[r]) * (r - l);

            maximumArea = Math.max(maximumArea, area);

            if(height[l] < height[r]){
                l++;
            } else{
                r--;
            }
        }

        return maximumArea;
    }
}
