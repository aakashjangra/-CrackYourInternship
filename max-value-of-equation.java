// Problem link - https://leetcode.com/problems/max-value-of-equation/

// TC - O(n log n)
// SC - O(n)
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> 
            (a[0] == b[0]) ? 
            Integer.compare(a[1], b[1]): // big first
            Integer.compare(b[0], a[0]) // small first
        );
        int maxValue = Integer.MIN_VALUE;
        for(int[] point: points){
            int yi = point[0], yj = point[1];
            while(pq.size() > 0 && yi - pq.peek()[1] > k){
                pq.poll();
            }
            if(!pq.isEmpty()){
                maxValue = Math.max(maxValue, pq.peek()[0] + yi + yj);
            }
            pq.offer(new int[]{yj - yi, yi});
        }

        return maxValue;
    }
}
