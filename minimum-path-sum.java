// Problem link - https://leetcode.com/problems/minimum-path-sum/

// TC - O(n * m)
// SC - O(n * m)
class Solution {
    int M, N;
    Integer[][] memo;
    public int minPathSum(int[][] grid) {
        M = grid.length;
        N = grid[0].length;
        memo = new Integer[M+1][N+1];
        int ans = helper(0, 0, grid);
        return ans;
    }
    public int helper(int i, int j, int[][] grid){
        //out of bound, if -1 is returned then don't consider it.
        if(i >= M || j >= N) return -1;

        //ans
        if(i == M-1 && j == N-1) return grid[i][j];

        //if ans exists, return memo
        if(memo[i][j] != null) return memo[i][j];

        //combinations, moves -> right and down
        int right = helper(i, j+1, grid);
        int down = helper(i+1, j, grid);

        int min = (right != -1 && down != -1)? Math.min(down, right) : down != -1? down: right;

        return memo[i][j] = grid[i][j] + min;
    }
}
