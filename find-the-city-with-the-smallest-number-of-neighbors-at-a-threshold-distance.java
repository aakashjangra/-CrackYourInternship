//Problem link - https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], 10001);
        }

        for(int[] e: edges){
            dist[e[0]][e[1]] = dist[e[1]][e[0]] = e[2];
        }

        for (int i = 0; i < n; i++)
            dist[i][i] = 0;

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
               for(int j = 0; j < n; j++){
                dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
               }
            }
        }

        int ans = 0, smallest = n;
        // min cities within threshold distance
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(dist[i][j] <= distanceThreshold)
                {
                    count++;
                }
            }

            if(count <= smallest){
                smallest = count;
                ans = i;
            }
        }

        return ans;
    }
}
