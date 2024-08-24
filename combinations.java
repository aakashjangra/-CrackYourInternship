// Problem link - https://leetcode.com/problems/combinations/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(1, n, k, new ArrayList<>(), ans);

        return ans;
    }

    private void helper(int cur, int n, int k, List<Integer> list, List<List<Integer>> ans){
        if(k == 0) {
            ans.add(list);
            return;
        }

        if(cur > n) return;

        for(int i = cur; i <= n; i++){
            List<Integer> temp = new ArrayList<>(list);
            temp.add(i);
            helper(i + 1, n, k - 1, temp, ans);
        }
    }
}
