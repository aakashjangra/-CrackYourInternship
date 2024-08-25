// Problem link - https://leetcode.com/problems/backspace-string-compare/

// TC - O(M + N)
// SC - O(M + N)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '#'){
                //backspace
                if(st1.size() > 0) st1.pop();
            } else {
                st1.push(c);
            }
        }
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(c == '#'){
                //backspace
                if(st2.size() > 0) st2.pop();
            } else {
                st2.push(c);
            }
        }

        if(st1.size() != st2.size()) return false;

        while(st1.size() > 0){
            if(st1.pop() != st2.pop()) return false;
        }

        return true;
    }
}
