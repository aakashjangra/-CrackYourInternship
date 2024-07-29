// Problem link - https://leetcode.com/problems/4sum/description/

// TC - O(n*n*n)
// SC - O(nlogn) - for sorting
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();

        Arrays.sort(nums); // so that we can exclude duplicates and do 2 pointer search

        int n = nums.length;

        for(int a = 0; a < n; a++){
            if(a > 0 && nums[a] == nums[a - 1]) continue;

            for(int b = a + 1; b < n; b++){
                if(b > a + 1 && nums[b] == nums[b - 1]) continue;

                int c = b + 1, d = n - 1;

                while(c < d){
                    if((long)nums[a] + nums[b] + nums[c] + nums[d] == target){
                        if(c > b + 1 && nums[c] == nums[c - 1]){
                            c++;
                            continue;
                        }
                        if(d < n - 1 && nums[d] == nums[d + 1]){
                            d--;
                            continue;
                        }

                        quadruplets.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        c++;
                        d--;
                    } else if ((long)nums[a] + nums[b] + nums[c] + nums[d] < target){
                        c++;
                    } else {
                        d--;
                    }
                }
            }

        }

        return quadruplets;
    }
}
