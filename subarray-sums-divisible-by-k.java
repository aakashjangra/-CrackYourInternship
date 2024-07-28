// Problem link - https://leetcode.com/problems/subarray-sums-divisible-by-k/

// TC - O(n)
// SC - O(n)

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int runningSum = 0;
        int subarrays = 0;

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];

            runningSum += num;

            runningSum = runningSum % k;

            if(runningSum < 0){
                runningSum += k;
            }

            if(map.containsKey(runningSum)){
                subarrays += map.get(runningSum);
            }

            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);
        }

        return subarrays;
    }
}
