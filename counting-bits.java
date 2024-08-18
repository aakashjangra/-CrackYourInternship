// Problem link - https://leetcode.com/problems/counting-bits/

// TC - O(N)
// SC - O(1)
class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        for(int i = 1; i <= n; i++){
            result[i] = result[i >> 1] + (i & 1);
        }

        return result;
    }
}
