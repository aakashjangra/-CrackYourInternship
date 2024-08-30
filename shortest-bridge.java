// Problem link - https://leetcode.com/problems/shortest-bridge/

class Solution {
    private int n;
    private int[][] moves =  {{-1,0}, {1,0}, {0,-1}, {0,1}};
    private Queue<int[]> queue;
    public int shortestBridge(int[][] grid) {
        queue = new ArrayDeque<>();

        n = grid.length;
        int x = 0, y = 0;
        boolean br = false;

        for(x = 0; x < n && !br; x++){
            for(y = 0; y < n && !br; y++){
                if(grid[x][y] == 1){
                    discoverIsland(grid, x, y);
                    br = true;
                }
            }
        }

        for(int cnt = 0; ;cnt++){
            for(int i = queue.size(); i > 0; i--){
                int[] pos = queue.poll();

                for(int[] move: moves){
                    int x2 = pos[0] + move[0];
                    int y2 = pos[1] + move[1];

                    if(x2 >= 0 && x2 < n && y2 >= 0 && y2 < n){
                        if(grid[x2][y2] == 1){
                            return cnt;
                        } else if(grid[x2][y2] == 0){
                            queue.add(new int[]{x2, y2});
                            grid[x2][y2] = -1;
                        }
                    }
                }
            }
        }
    }

    private void discoverIsland(int[][] grid, int x, int y){
        grid[x][y] = 2;
        queue.add(new int[]{x, y});

        for(int[] move: moves){
            int x2 = x + move[0];
            int y2 = y + move[1];

            if (x2 >= 0 && x2 < n && y2 >= 0 && y2 < n){
                if(grid[x2][y2] == 1){
                    discoverIsland(grid, x2, y2);
                }
            }
        }
    }
}
