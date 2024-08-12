// Problem link - https://leetcode.com/problems/maximum-product-of-three-numbers/

// TC - O(N log N)
// SC - O(1)
class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); //sort in asc. order

        int ans1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int ans2 = nums[0] * nums[1] * nums[n - 1];

        return Math.max(ans1, ans2);
    }
}
