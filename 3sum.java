// Problem link - https://leetcode.com/problems/3sum/description/

// TC - O(n * n)
// SC - O(nlogn) - (sorting)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            //skipping duplicates
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int target = -nums[i];

            int j = i + 1, k = n - 1;

            while(j < k){
                if(nums[j] + nums[k] == target){
                    if(j > i + 1 && nums[j] == nums[j - 1]){
                        j++;
                        continue;
                    }
                    if(k < n - 1 && nums[k] == nums[k + 1]){
                        k--;
                        continue;
                    }
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);

                    triplets.add(triplet);
                    j++;
                } else if(nums[j] + nums[k] < target){
                    j++;
                } else {
                    k--;
                }
            }
        }

        return triplets;
    }
}
