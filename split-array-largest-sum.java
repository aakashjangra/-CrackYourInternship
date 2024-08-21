//Problem link - https://leetcode.com/problems/split-array-largest-sum/

// TC - O(log(m) * n), n is the length of nums and m is the totalSum of nums
// SC - O(1)
class Solution {
    public int splitArray(int[] nums, int k) {
        int total = 0;
        for(int val: nums) total += val;

        int l = 0, r = total; // sum
        int ans = -1;

        while(l <= r){
            int mid = (l + r)/2;

            if(check(nums, k, mid)){
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    private boolean check(int[] nums, int k, int maxSum){
        int sum = 0;
        int groups = 1;
        for(int num: nums){
            if(num > maxSum) return false;
            sum += num;

            if(sum > maxSum){
                groups++;
                sum = num;
            }
        }

        if(groups <= k) return true;
        return false;
    }
}
