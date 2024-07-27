// Problem link - https://leetcode.com/problems/daily-temperatures/

// TC - O(n)
// SC - O(n)
class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){

            while(st.size() > 0 && temp[st.peek()] < temp[i]){
                int top = st.pop();

                ans[top] = (i - top);
            }

            st.push(i);
        }

        return ans;
    }
}
