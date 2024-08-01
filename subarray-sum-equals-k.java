// Problem link - https://leetcode.com/problems/subarray-sum-equals-k/

// TC - O(n)
// SC - O(n)
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();

        int sum = 0;
        frequencies.put(0, 1);
        int validSubarrays = 0;

        for(int num: nums){
            sum += num;

            if(frequencies.containsKey(sum - k)){
                validSubarrays += frequencies.get(sum - k);
            }

            frequencies.put(sum, frequencies.getOrDefault(sum, 0) + 1);
        }

        return validSubarrays;
    }
}
