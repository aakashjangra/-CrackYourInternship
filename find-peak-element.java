// Problem link - https://leetcode.com/problems/find-peak-element/

// TC - O(log n)
// SC - O(1)
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        
        while(l <= r){
            int mid = l + (r - l)/2;
            
            if(mid == 0 || nums[mid - 1] < nums[mid]){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return l - 1;
    }
}
