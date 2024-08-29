// Problem link - https://leetcode.com/problems/flood-fill/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        //int[] -> {row, col}
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int m = image.length, n = image[0].length;
        int[][] vis = new int[m][n];
        queue.add(new int[]{sr, sc});
        vis[sr][sc] = 1; //mark as visited

        //applying bfs to fill color
        while(!queue.isEmpty()){
            int[] coord = queue.poll();
            int r = coord[0], c = coord[1];
            
            for(int[] dir: dirs){
                int x = dir[0], y = dir[1];
                int rn = r + x, cn = c + y;

                if(rn >= 0 && cn >= 0 && rn < m && cn < n && vis[rn][cn] == 0 && image[r][c] == image[rn][cn]){
                    //same color -> add to queue
                    queue.add(new int[]{rn, cn});
                    vis[rn][cn] = 1;
                }
            }

            image[r][c] = color;
        }

        return image;
    }
}
