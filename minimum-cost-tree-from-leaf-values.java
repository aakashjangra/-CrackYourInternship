// Problem link - https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/description/

// TC - O(n)
// SC - O(n)
class Solution {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int minSum = 0;

        st.push(Integer.MAX_VALUE);

        for(int num: arr){
            while(st.peek() <= num){
                int smallValue = st.pop();
                minSum += smallValue * Math.min(st.peek(), num);
            }

            st.push(num);
        }

        while(st.size() > 2){
            minSum += st.pop() * st.peek();
        }

        return minSum;
    }
}
