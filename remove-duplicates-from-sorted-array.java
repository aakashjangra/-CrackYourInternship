//Problem link - https://leetcode.com/problems/remove-duplicates-from-sorted-array/

class Solution {
    public int removeDuplicates(int[] nums) {
        int indx = 1;

        int prev = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(prev != nums[i]){
                //new element
                nums[indx] = nums[i];
                indx++;
            }

            prev = nums[i];
        }

        return indx;
    }
}
