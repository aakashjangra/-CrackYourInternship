// Problem link - https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/


// TC - O(m + n)
// SC - O(1)
// Approach A 
class Solution {
    public int strStr(String haystack, String needle) {

        int j = 0;

        int n = haystack.length();

        while(j < n - needle.length() + 1){
            if(needle.equals(haystack.substring(j, j + needle.length()))) return j;

            j++;
        }

        return -1;
    }
}

// TC - O(n*n)
// SC - O(1)
// Approach B
class Solution {
    public int strStr(String haystack, String needle) {

        int i = 0, j = 0;

        int n = haystack.length();

        while(j < n){
            if(haystack.charAt(j) != needle.charAt(j - i)){
                j = i;
                i = i + 1;
            } else{
                if(j - i + 1 == needle.length()) return i;
            }

            j++;
        }

        return -1;
    }
}

// TC - O(m*n)
// SC - O(1)
// Approach C
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
