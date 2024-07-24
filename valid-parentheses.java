// Problem Link - https://leetcode.com/problems/valid-parentheses/description/

// TC - O(n)
// SC - O(n)

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '(' || c == '[' || c == '{'){
                st.push(c);
            } else {
                //closing bracket
                if(st.size() == 0) return false; //invalid paranthesis

                if(c == ')' && st.peek() == '('){
                    st.pop();
                } else if(c == ']' && st.peek() == '['){
                    st.pop();
                } else if(c == '}' && st.peek() == '{'){
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        return st.size() == 0;
    }
}
