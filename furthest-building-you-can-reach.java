// Problem link - https://leetcode.com/problems/furthest-building-you-can-reach/

// TC - O(n log n)
// SC - O(n)
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 1; i < heights.length; i++){
            if(heights[i - 1] >= heights[i]) continue;

            int diff = heights[i] - heights[i - 1];
            minHeap.offer(diff);

            if(minHeap.size() > ladders){
                // we have to cover least one with the bricks, if we can't then we return the last index
                int toUse = minHeap.poll();
                if(bricks < toUse) return i - 1;
                bricks -= toUse;
            }
        }

        return heights.length - 1;
    }
}
