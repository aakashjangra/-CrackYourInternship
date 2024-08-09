Problem link - https://leetcode.com/problems/evaluate-reverse-polish-notation/

// TC - O(N)
// SC - O(N)
class Solution {
    public int evalRPN(String[] tokens) {
        //postfix notation
        int ans = 0;

        Stack<Integer> st = new Stack<>();

        for(String token: tokens){
            if(token.equals("+")){
                int a = st.pop();
                int b = st.pop();
                int sum = a + b;
                st.push(sum);
            } else if(token.equals("-")){
                int b = st.pop();
                int a = st.pop();
                int diff = a - b;
                st.push(diff);
            } else if(token.equals("*")){
                int a = st.pop();
                int b = st.pop();
                int prod = a * b;
                st.push(prod);
            } else if(token.equals("/")){
                int b = st.pop();
                int a = st.pop();
                int quotient = a / b;
                st.push(quotient);
            } else {
                //parse to int and push to stack
                st.push(Integer.parseInt(token));
            }
        }

        return st.peek();
    }
}
