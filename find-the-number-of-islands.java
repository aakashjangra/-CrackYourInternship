// Problem link - https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1

// TC - O(n*m)
// SC - O(1)
class Solution {
    // Function to find the number of islands.
    final int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {1, 1}, {1, -1}, {-1, 0}, {-1, 1}, {-1, -1}};

    public int numIslands(char[][] grid) {
        int islands = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    islands++;
                    dfs(i, j, grid);
                }   
            }
        }
        
        // reverting grid back to it's original state
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '2'){
                    grid[i][j] = '1';
                }   
            }
        }
        
        return islands;
    }
    
    public void dfs(int i, int j, char[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1'){
            return;
        }
        
        // we can make the original array later, by just replacing 2 with 1
        grid[i][j] = '2';
        
        for(int[] dir: dirs){
            int x = dir[0] + i, y = dir[1] + j;
            
            dfs(x, y, grid);
        }
    }
}
