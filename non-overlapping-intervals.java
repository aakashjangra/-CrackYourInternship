// Problem link - https://leetcode.com/problems/non-overlapping-intervals/

// TC - O(N log N)
// SC - O(1)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, 
        (a,b) -> a[0] - b[0]
        );

        int x = intervals[0][0], y = intervals[0][1];

        int countOfRemovedIntervals = 0;
        for(int i = 1; i < intervals.length; i++){
            int a = intervals[i][0], b = intervals[i][1];
            if(y <= a){
                x = a;
                y = b;
            } else {
                y = Math.min(y, b); // will delete bigger range interval
                countOfRemovedIntervals++;
            }
        }

        return countOfRemovedIntervals;
    }
}
