// Problem link - https://leetcode.com/problems/beautiful-arrangement/

class Solution {
    public int countArrangement(int n) {
        int[] arr = new int[n + 1];
        int ans = 0;

        ans = helper(1, n, arr, ans);

        return ans;
    }
    private int helper(int cur, int n, int[] arr, int ans){
        if(cur == n + 1){
            ans++;
            return ans;
        }

        for(int i = 1; i <= n; i++){
            if(arr[i] == 0 && (cur % i == 0 || i % cur == 0)){
                arr[i] = cur;
                ans = helper(cur + 1, n, arr, ans);
                arr[i] = 0;
            }
        }

        return ans;
    }
}
