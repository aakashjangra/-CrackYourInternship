// Problem link - https://leetcode.com/problems/unique-paths-iii/

class Solution {
    // 4 - directional
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int uniquePathsIII(int[][] grid) {
        int startingSquare[] = {-1, -1};
        int walkableSquares = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    //starting square
                    startingSquare[0] = i;
                    startingSquare[1] = j;
                }
                if(grid[i][j] == 0) walkableSquares++;
            }
        }

        if(startingSquare[0] == -1) return 0;

        return helper(startingSquare[0], startingSquare[1], walkableSquares + 1, grid);
    }

    private int helper(int i, int j, int walkableSquares, int[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1){
            return 0;
        }

        if(grid[i][j] == 2) {
            //ending square
            if(walkableSquares == 0)
            return 1; // 1 path found

            return 0;
        }

        int originalValue = grid[i][j];
        grid[i][j] = -1;

        int ans = 0;
        for(int[] dir: dirs){
            int x = i + dir[0], y = j + dir[1];
            ans += helper(x, y, walkableSquares - 1, grid);
        }

        grid[i][j] = originalValue;

        return ans;
    }
}
