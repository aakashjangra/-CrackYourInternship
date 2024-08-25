// Problem link - https://leetcode.com/problems/subsets-ii/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Set<String> set = new HashSet<>();

        Arrays.sort(nums);

        helper(0, new ArrayList<>(), new StringBuilder(), nums, subsets, set);

        return subsets;
    }

    private void helper(int pos, List<Integer> subset, StringBuilder hash, int[] nums, List<List<Integer>> subsets, Set<String> set){
        if(pos == nums.length) {
            if(set.contains(hash.toString())) return;

            set.add(hash.toString()); 
            subsets.add(subset); 
            return;
        }

        // not take
        helper(pos + 1, subset, hash, nums, subsets, set);

        // take 
        List<Integer> temp = new ArrayList<>(subset);
        temp.add(nums[pos]);
        StringBuilder sb = new StringBuilder(hash);
        sb.append(Integer.toString(nums[pos]));
        helper(pos + 1, temp, sb, nums, subsets, set);
    }
}
