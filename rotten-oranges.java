// Problem link - https://www.geeksforgeeks.org/problems/rotten-oranges2536/1

// TC - O(n*m)
// SC - O(n*m)
class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        Queue<int[]> q = new ArrayDeque<>();
        int n = grid.length, m = grid[0].length;
        int freshOranges = 0;
        
        // insert all the rotten orange positions in q
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    //rotten orange
                    q.offer(new int[]{i, j});
                } else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        
        if(freshOranges == 0) return 0;
        
        // up, down, left and right
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        // bfs, count number of times bfs is run (as time)
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0){
                int[] cur = q.poll();
                int i = cur[0], j = cur[1];
                
                for(int[] dir: dirs){
                    int x = i + dir[0], y = j + dir[1];
                    
                    if(x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1){
                        //should be valid index and fresh orange
                        // make it rotten and add to q
                        grid[x][y] = 2;
                        q.offer(new int[]{x, y});
                        freshOranges--;
                    }
                }
            }
            
            time++;
        }
        
        // if any rotten orange remains, return -1, else time
        if(freshOranges > 0) return -1;
        
        return time - 1;
    }
}
