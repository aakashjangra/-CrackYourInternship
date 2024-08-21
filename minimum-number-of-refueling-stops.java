// Problem link - https://leetcode.com/problems/minimum-number-of-refueling-stops/

// TC - O(N log N)
// SC - O(N)
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // pq is a maxheap of gas station capacities
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        int ans = 0, prev = 0, tank = startFuel;
        for(int[] station: stations){
            int location = station[0];
            int capacity = station[1];
            tank -= location - prev;
            while(!pq.isEmpty() && tank < 0){
                //refuel
                tank += pq.poll();
                ans++;
            }

            if(tank < 0) return -1;
            pq.offer(capacity);
            prev = location;
        }

        tank -= target - prev;
        while(!pq.isEmpty() && tank < 0){
            tank += pq.poll();
            ans++;
        }
        
        if(tank < 0) return -1;

        return ans;
    }
}
