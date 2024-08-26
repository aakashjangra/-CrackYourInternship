// Problem link - https://leetcode.com/problems/palindrome-partitioning/

class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        
        helper(0, 0, new ArrayList<>(), s);

        return ans;
    }
    private void helper(int st, int cur, List<String> list, String s){
        if(cur == s.length()){
            if(st == cur){
                ans.add(list);
            }
                return;
        }

        // 2 choice
        // take it if it's palindrome
        // check palindrome for the current str 
        // add to list if it's palindrome
        if(palindrome(st, cur, s)){
            List<String> temp = new ArrayList<>(list);
            temp.add(s.substring(st, cur + 1));
            helper(cur + 1, cur + 1, temp, s);
        }

        // not take it
        helper(st, cur + 1, new ArrayList<>(list), s);
    }

    private boolean palindrome(int s, int e, String str){
        while(s < e){
            if(str.charAt(s) != str.charAt(e)) return false;
            s++;
            e--;
        }
        return true;
    }
}
