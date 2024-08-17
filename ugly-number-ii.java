// Problem link - https://leetcode.com/problems/ugly-number-ii/

// TC - O(N log N)
// SC - O(N)
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(1l);

        for(int i = 0; i < n - 1; i++){
            long val = pq.poll();
            while(pq.size() > 0 && pq.peek() == val) pq.poll();
            pq.offer(val * 2);
            pq.offer(val * 3);
            pq.offer(val * 5);
        }

        return pq.peek().intValue();
    }
}
