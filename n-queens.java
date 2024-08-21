// Problem link - https://leetcode.com/problems/n-queens/
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[][] grid = new int[n][n];

        helper(0, 0, grid, ans, n);

        return ans;
    }

    private void helper(int r, int queensPlaced, int[][] grid, List<List<String>> ans, int n){
        if(r == n && queensPlaced == n){
            List<String> state = stringFromGrid(grid);
            ans.add(state);
            return;
        }

        if(r == n) return;

        

        for(int c = 0; c < n; c++){
                //if valid move
                if(validMove(r, c, grid)){
                    grid[r][c] = 1; //placed queen

                    // we have placed a queen in each of prev. rows, so next queen can only be placed in next row in any column 
                    helper(r + 1, queensPlaced + 1, grid, ans, n);

                    //remove queen
                    grid[r][c] = 0;
                }
        }
    }

    // private void printGrid(int[][] grid, int n){
    //     System.out.println("Grid-");
    //     for(int i = 0; i < n; i++){
    //         for(int j = 0; j < n; j++){
    //             System.out.print(grid[i][j]+" ");
    //         }
    //         System.out.println();
    //     }
    // }

    int[][] diags = {{-1, -1}, {-1, 1}};
    private boolean validMove(int i, int j, int[][] grid){
        int n = grid.length;
        // this col should not have another queen
        for(int x = 0; x < i; x++){
            if(grid[x][j] == 1){
                 return false;
            }
        }

        // this diagonal should not have another queen

        //left up diag
        int rIncr = -1;
        int cIncr = -1;
        int y = j;
        int x = i;
        while(x + rIncr >= 0 && y + cIncr >= 0){
            if(grid[x + rIncr][y + cIncr] == 1) return false;//queen found
            y = y + cIncr;
            x = x + rIncr;
        }   
        //right up diag
        cIncr = 1;
        y = j;
        x = i;
        while(x + rIncr >= 0 && y + cIncr < n){
            if(grid[x + rIncr][y + cIncr] == 1) return false;//queen found
            y = y + cIncr;
            x = x + rIncr;
        }   

        return true;
    }
    private List<String> stringFromGrid(int[][] grid){
        List<String> state = new ArrayList<>();
        int n = grid.length;

        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }

            state.add(sb.toString());
        }

        return state;
    }
}
