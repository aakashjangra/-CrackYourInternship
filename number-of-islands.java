// Problem link - https://leetcode.com/problems/number-of-islands/

// TC - O(m * n)
// SC - O(m * n)
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] vis = new int[m][n];

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int nOfIslands = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    nOfIslands++;

                    //run bfs
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    vis[i][j] = 1;

                    while(q.size() > 0){
                        int[] cur = q.poll();
                        int a = cur[0], b = cur[1];

                        for(int indx = 0; indx < 4; indx++){
                            int x = a + dirs[indx][0], y = b + dirs[indx][1];

                            if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1' && vis[x][y] == 0){
                                q.add(new int[]{x, y});
                                vis[x][y] = 1;
                            }
                        }
                    }
                }
            }
        }

        return nOfIslands;
    }
}
