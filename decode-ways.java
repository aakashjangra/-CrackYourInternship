// Problem link - https://leetcode.com/problems/decode-ways/

// TC - O(N)
// SC - O(N)
class Solution {
    Integer[] memo;
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;

        memo = new Integer[s.length()];
        return ways(0, s, s.length());
    }
    private int ways(int pos, String s, int n){
        if(pos == n) return 1;

        if(memo[pos] != null) return memo[pos];

        int count = 0;
        // take single digit char
        // can't take single digit when it's '0'
        if(s.charAt(pos) != '0'){
            count = ways(pos + 1, s, n);
        }
        // take double digit char, if double digit is <= 26
        if(pos < n-1 && (s.charAt(pos) == '1' || (s.charAt(pos) == '2' && s.charAt(pos + 1) <= '6'))){
            count += ways(pos + 2, s, n);
        }

        return memo[pos] = count;
    }
}
