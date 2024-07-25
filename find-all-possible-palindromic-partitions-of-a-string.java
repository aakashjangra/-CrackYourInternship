// Problem link - https://www.geeksforgeeks.org/problems/find-all-possible-palindromic-partitions-of-a-string/1

// n is the length of string S
// TC - O(n * 2^n)
// SC - O(n * n)

class Solution {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        
        helper(0, S, new ArrayList<>(), ans);
        
        return ans;
    }
    
    static void helper(int pos, String str, ArrayList<String> cur, ArrayList<ArrayList<String>> ans){
        if(pos == str.length()) {
            ans.add(cur);
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = pos; i < str.length(); i++){
            sb.append(str.charAt(i));
            
            if(isPalindrome(sb)){
                ArrayList<String> temp = new ArrayList<>(cur);
                temp.add(sb.toString());
                
                helper(i + 1, str, temp, ans);
            }
        }
    }
    
    static boolean isPalindrome(StringBuilder sb){
        int s = 0, e = sb.length() - 1;
        
        while(s < e){
            if(sb.charAt(s) != sb.charAt(e)) return false;
            
            s++;
            e--;
        }
        
        return true;
    }
};
