// Problem link - https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/

// TC - O(n log n)
// SC - O(1)
class Solution {
    public int minMoves2(int[] nums) {

        int sumOfMoves = 0;

        // sort in ascending order, O(n log n)
        Arrays.sort(nums);

        int n = nums.length;

        int median = nums[n / 2]; 

        for(int val: nums){
        // change every element into median
            sumOfMoves += Math.abs(val - median);
        }

        return sumOfMoves;
    }
}
