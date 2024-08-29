// Problem link - https://www.geeksforgeeks.org/problems/steps-by-knight5927/1

class Solution
{
    int[][] ways = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {1, -2}, {-1, 2}, {1, 2}};
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        //it's a chessboard N x N
        int[][] vis = new int[N + 1][N + 1];
        //bfs 
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(KnightPos);
        vis[KnightPos[0]][KnightPos[1]] = 1; //mark visited
        
        int steps = 0;
        
        while(q.size() > 0){
            int s = q.size();
            
            while(s-- > 0){
                int[] coords = q.poll();
                int i = coords[0], j = coords[1];
                
                if(i == TargetPos[0] && j == TargetPos[1]) return steps;
                
                for(int[] way: ways){
                    int x = i + way[0], y = j + way[1];
                    
                    if(x >= 1 && x <= N && y >= 1 && y <= N && vis[x][y] == 0){
                        q.offer(new int[]{x, y});
                        vis[x][y] = 1;
                    }
                }
            }
            
            steps++;
        }
        
        
        
        return -1;
    }
}
