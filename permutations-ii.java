// Problem link - https://leetcode.com/problems/permutations-ii/

class Solution {
    int vis[];
    int n;
    List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;
        ans = new ArrayList<>();
        vis = new int[n];

        Arrays.sort(nums); // for duplicates

        helper(new ArrayList<>(), nums);

        return ans;
    }

    private void helper(List<Integer> comb, int[] nums){
    
        if(comb.size() == n){
            ans.add(new ArrayList<>(comb));
            return;
        }

        for(int i = 0; i < n; i++){
            if(vis[i] == 1 || (i > 0 && nums[i] == nums[i - 1] && vis[i - 1] == 1)) continue;

            vis[i] = 1;

            comb.add(nums[i]);
            helper(comb, nums);
            comb.remove(comb.size() - 1);

            vis[i] = 0;
        }
    }
}
