// Problem link - https://leetcode.com/problems/find-the-duplicate-number/description/

class Solution {
    public int findDuplicate(int[] nums) {
        int ans = -1;
        for(int i = 0; i < nums.length; i++){
            int ind = Math.abs(nums[i]);
            if(nums[ind] < 0){
                ans = ind;
                break;
            }
            nums[ind] = -nums[ind];
        }

        //returning array to it's previous state
        for(int i = 0; i < nums.length; i++){
            int ind = Math.abs(nums[i]);
            if(nums[ind] < 0){
                nums[ind] = -nums[ind];
            }
        }

        return ans;
    }
}

// //Different approaches using Sorting + Linear Search, Sorting + Binary Search, HashSet can be used but they will not satisfy the conditions - 
// 1. Array should not be modified
// 2. Linear extra space should be used
