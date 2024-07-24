// Problem link - https://leetcode.com/problems/longest-common-prefix/description/

// n is the size of array and m is the size of string (element of array)
// TC - O(n * m)
// SC - O(m)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String common = strs[0];

        for(int i = 1; i < strs.length; i++){
            String str = strs[i];

            int j = 0;

            while(j < Math.min(common.length(), str.length())){
                if(common.charAt(j) != str.charAt(j)){
                    break;
                }

                j++;
            }

            common = str.substring(0, j);
        }


        return common;
    }
}
