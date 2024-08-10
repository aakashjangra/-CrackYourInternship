// Problem link - https://leetcode.com/problems/move-zeroes/

// TC - O(N)
// SC - O(1)
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int firstZeroIndex = 0;

        for(int i = 0; i < n; i++){
            while(firstZeroIndex < n && nums[firstZeroIndex] != 0){
                firstZeroIndex++;
            }

            if(nums[i] != 0 && i > firstZeroIndex){
                int temp = nums[i];
                nums[i] = 0;
                nums[firstZeroIndex++] = temp;
            }
        }
    }
}
