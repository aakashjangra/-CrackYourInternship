// Problem link - https://leetcode.com/problems/gas-station/

// TC - O(n)
// SC - O(1)

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalDiff = 0;
        int n = gas.length;

        int highest = Integer.MIN_VALUE;
        
        //find the starting index
        int startingIndex = 0;

// we are iterating from the back, because we want to travel in clockwise direction
        for(int i = n - 1; i >= 0; i--){
            //gas is how much we are getting
            //cost is how much we are spending
            totalDiff += gas[i] - cost[i];

            if(totalDiff > highest){
                highest = totalDiff;
                startingIndex = i;
            }
        }

        // if totalDiff is neg. then not possible to travel around the circuit once
        if(totalDiff < 0) return -1;

        //otherwise solution exists
        return startingIndex;
    }
}
