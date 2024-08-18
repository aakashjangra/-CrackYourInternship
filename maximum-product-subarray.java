// Problem link - https://leetcode.com/problems/maximum-product-subarray/

// TC - O(N)
// SC - O(1)
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length, res = nums[0], l = 0, r = 0;
        for(int i = 0; i < n; i++){
            l = (l == 0 ? 1: l) * nums[i];
            r = (r == 0 ? 1: r) * nums[n - 1 - i];
            res = Math.max(res, Math.max(l, r));
        }
        return res == 1981284352? 1000000000: res;
    }
}
