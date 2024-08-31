// Problem link - https://leetcode.com/problems/as-far-from-land-as-possible/

class Solution {
    public int maxDistance(int[][] grid) {
       int dist = -1;
       int n = grid.length;
       boolean[][] vis = new boolean[n][n];
       ArrayDeque<int[]> bfs = new ArrayDeque<>();

       for(int i = 0; i<n; i++){
           for(int j = 0; j<n; j++){
               if(grid[i][j] == 1){
                   //if land, add to queue
                   bfs.add(new int[]{i, j});
               }
           }
       }

       // left, right, up, down
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!bfs.isEmpty()){
           int size = bfs.size();
           for(int a = 0; a<size; a++){
                int[] coord = bfs.poll();

                for(int[] dir: dirs){
                    int x = dir[0] + coord[0];
                    int y = dir[1] + coord[1];

                    if(valid(x, y, n)){
                        if(vis[x][y]) continue;
                        //water then add to queue
                        if(grid[x][y] == 0)
                            bfs.add(new int[]{x, y});
                            
                        vis[x][y] = true;
                    }
                }       
           }
           dist++;
        }

       return dist == 0? -1: dist; 
    }

    public boolean valid(int x, int y, int n){
        if(x < 0 || y < 0 || x >= n || y >= n) return false;

        return true;
    }
}
