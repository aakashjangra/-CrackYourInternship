// Problem link - https://leetcode.com/problems/subsets/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        ansList.add(new ArrayList<>()); //empty subset {}

        addSubsets(ansList, new ArrayList<>(), 0, nums);

        return ansList;
    }

    private void addSubsets(List<List<Integer>> ans, List<Integer> subset, int i, int[] nums){
        if(i == nums.length) return;


        addSubsets(ans, new ArrayList<>(subset), i+1, nums);

        subset.add(nums[i]);
        ans.add(new ArrayList<>(subset));

        addSubsets(ans, new ArrayList<>(subset), i+1, nums);
    }
}
