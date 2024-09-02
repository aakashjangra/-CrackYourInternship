// Problem link - https://www.geeksforgeeks.org/water-jug-problem-using-bfs/

class Solution
{
    public int minSteps(int m, int n, int d)
    {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] vis = new int[m + 1][n + 1];
        q.offer(new int[]{0, 0});
        
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0){
                int[] coords = q.poll();
                int i = coords[0], j = coords[1];
                
                if(vis[i][j] == 1) continue;
                vis[i][j] = 1;
                
                if(i == d || j == d) return steps;
                
                // do operations
                // 1. empty a jug
                q.offer(new int[]{i, 0});
                q.offer(new int[]{0, j});
                // 2. fill a jug
                q.offer(new int[]{i, n});
                q.offer(new int[]{m, j});
                // 3. pour water from one jug to the other until one of the jugs is either empty or full.
                // pour from first to second
                int toPour = Math.min(i, n - j);
                q.offer(new int[]{i - toPour, j + toPour});
                // pour from second to first
                toPour = Math.min(m - i, j);
                q.offer(new int[]{i + toPour, j - toPour});
            }
        
            steps++;
        }
        
        return -1;
    }
}
