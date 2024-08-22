// Problem link - https://leetcode.com/problems/delete-and-earn/

// TC - O(M + N)
// SC - O(M), N is the length of nums and M is the maximum number in nums
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = nums[0];
        for(int num: nums){
            if(max < num) max = num;
        }

        int[] dp = new int[max + 1];
        for(int num: nums){
            dp[num] += num;
        }

        for(int i = 2; i <= max; i++){
            dp[i] = Math.max(dp[i - 2] + dp[i], dp[i - 1]);
        }

        return dp[max];
    }
}
