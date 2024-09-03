// Problem link - https://leetcode.com/problems/making-a-large-island/

class Solution {
    final int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        //calculate max area acievable by not swapping/swapping a 0 with 1
        int maxArea = 0;
        Map<Integer, Integer> areaOfRegion = new HashMap<>();
        areaOfRegion.put(0, 0);
        //mark distinct regions
        int region = 2;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int area = dfs(i, j, region, grid, n);
                    areaOfRegion.put(region, area);
                    region++;

                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    // sum area of 4-directional unique regions, if exists
                    Set<Integer> set = new HashSet<>();
                    int areaAchievable = 1; // 1 for the current cell
                    for(int[] dir: dirs){
                        int x = dir[0] + i, y = dir[1] + j;
                        if(x < 0 || x >= n || y < 0 || y >= n) continue;
                        region = grid[x][y];
                        if(set.contains(region)) continue;
                        set.add(region);
                        areaAchievable += areaOfRegion.get(region);
                    }

                    maxArea = Math.max(maxArea, areaAchievable);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int x, int y, int region, int[][] grid, int n){
        if(x < 0 || x >= n || y < 0 || y >= n || grid[x][y] != 1) return 0;

        grid[x][y] = region;
        int area = 1;

        // 4 - directional
        for(int[] dir: dirs){
            int i = dir[0] + x, j = dir[1] + y;

            area += dfs(i, j, region, grid, n);
        }

        return area;
    }
}
