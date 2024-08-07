// Problem link - https://leetcode.com/problems/frog-jump/

// Approach 1: dp
// TC - O(n * n)
// SC - O(n * n)
class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n + 1];
        dp[0][1] = true;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                int diff = stones[i] - stones[j];
                if(diff < 0 || diff > n || !dp[j][diff]) continue;
                dp[i][diff] = true;
                if(diff - 1 >= 0) dp[i][diff - 1] = true;
                if(diff + 1 <= n) dp[i][diff + 1] = true;
                if(i == n - 1) return true;
            }
        }

        return false;
    }
}

// Approach 2
// TC - O(n * n)
// SC - O(n * n)
class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> stoneToJumps = new HashMap<>();

        if(stones[1] != 1) return false;
        for(int stone: stones){
            stoneToJumps.put(stone, new HashSet<>());
        }

        stoneToJumps.get(1).add(1); // we reach stone 1 at pos 1, with 1 initial jump

        for(int stone: stones){
            // we reached the last stone and there is atleast one way to reach it
            if(stoneToJumps.get(stone).size() > 0 && stone == stones[stones.length - 1]) return true;

            for(int k: stoneToJumps.get(stone)){
                for(int i = -1; i <= 1; i++){
                    // k - 1, k, k + 1
                    int nextStone = (stone + k + i);
                    if(stoneToJumps.containsKey(nextStone) && stone != nextStone){
                        stoneToJumps.get(nextStone).add(nextStone - stone);
                    }
                }
            }
        }

        return false;
    }
}
