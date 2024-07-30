// Problem link - https://leetcode.com/problems/jump-game/

// TC - O(n)
// SC - O(1)

class Solution {
    public boolean canJump(int[] nums) {
        int movesLeft = 0;

        int i = 0;
        while(i < nums.length - 1){
            movesLeft--;

            int num = nums[i];
            movesLeft = Math.max(movesLeft, num);

            if(movesLeft <= 0) return false;
            i++;
        }

        return (i == nums.length - 1);
    }
}
