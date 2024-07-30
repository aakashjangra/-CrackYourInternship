// Problem Link - https://leetcode.com/problems/generate-parentheses/

// TC - O(2 ^ 2n)
// SC - O(n) - for the stringBuilder
class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> pairs = new ArrayList<>();
        StringBuilder pair = new StringBuilder();

        // n is number of pairs, 
        // n * 2 == length of generated string
        helper(0, 0, n * 2, pair, pairs);

        return pairs;
    }

    private void helper(int open, int close, int limit, StringBuilder pair, List<String> pairs){
        if(open + close > limit) return;

        if(open + close == limit) {
            pairs.add(pair.toString());
            return;
        }

        // we can add either a '('
        if(open < limit/2){
            StringBuilder tempPair = new StringBuilder(pair);
            tempPair.append('(');
            helper(open + 1, close, limit, tempPair, pairs);
        }

        // or a ')'
        if(open > close){
            StringBuilder tempPair = new StringBuilder(pair);
            tempPair.append(')');
            helper(open, close + 1, limit, tempPair, pairs);
        }
    }
}
