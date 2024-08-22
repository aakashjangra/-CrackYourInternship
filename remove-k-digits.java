// Problem link - https://leetcode.com/problems/remove-k-digits/

// TC - O(N + k)
// SC - O(N + k)
class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < n; i++){
            char c = num.charAt(i);

            while(k > 0 && st.size() > 0 && st.peek() > c){
                st.pop();
                k--;
            }

            st.push(c);
        }

        StringBuilder sb = new StringBuilder();

        while(k > 0){
           st.pop(); 
           k--;
        }

        

        // make string out of stack elements
        while(st.size() > 0){
           sb.append(st.pop()); 
        }

        //reverse, as stack pop returns string in reverse order
        sb.reverse();

        int i = 0;
        //remove leading zeros
        while(i < sb.length() - 1 && sb.charAt(i) == '0'){
            i++;
        }

        String ans = sb.toString();

        String ansFiltered = ans.substring(i, ans.length());

        return ansFiltered.length() == 0? "0": ansFiltered;
    }
}
