// Problem link - https://leetcode.com/problems/k-closest-points-to-origin/

// TC - O(n log k)
// SC - O(k)
class Solution {
    class Custom{
        int x;
        int y;
        double dist;
        Custom(int x, int y, double dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Custom> pq = new PriorityQueue<>((a,b) -> Double.compare(b.dist, a.dist));

        //origin - {0, 0}
        for(int[] point: points){
            int x = point[0], y = point[1];
            double euclideanDist = Math.sqrt((x*x) + (y*y));
            pq.offer(new Custom(x, y, euclideanDist));

            if(pq.size() > k) pq.poll();
        }

        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++){
            Custom cur = pq.poll();
            ans[i] = new int[]{cur.x, cur.y};
        }

        return ans;
    }
}
