// Problem link - https://leetcode.com/problems/find-the-most-competitive-subsequence/

// TC - O(N)
// SC - O(N)
class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && nums[i] < nums[st.peek()] && n - i - 1 >= k - st.size()){
                st.pop();
            }

            if(st.size() < k){
                st.push(i);
            }
        }

        int[] ans = new int[k];
        int i = k - 1; 
        while(st.size() > k) st.pop();
        while(!st.isEmpty()){
            ans[i] = nums[st.pop()];
            i--;
        }

        return ans;
    }
}
