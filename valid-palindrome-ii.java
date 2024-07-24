// Problem Link - https://leetcode.com/problems/valid-palindrome-ii/description/

// TC - O(n)
// SC - O(1)
class Solution {
    public boolean validPalindrome(String s) {

        boolean chanceUsed = false;

        int l = 0, r = s.length() - 1;

        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return (isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1));
            }
            
            l++;
            r--;
        }

        return true;
    }

    private boolean isPalindrome(String str, int s, int e){
        while(s < e){
            if(str.charAt(s) != str.charAt(e)) return false;

            s++;
            e--;
        }

        return true;
    }
}
