// Problem link - https://leetcode.com/problems/frog-jump/

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
