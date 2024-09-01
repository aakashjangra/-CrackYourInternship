// Problem link - https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if(row == 1 && col == 1) return 1;

        int max = 1;

        List<int[]> numList = new ArrayList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                numList.add(new int[]{matrix[i][j], i, j});
            }
        }

        Collections.sort(numList, (a, b) -> b[0] - a[0]);

        int[][] dp = new int[row][col];
        for(int i = 0; i < row; i++)
        {
            Arrays.fill(dp[i], 1);
        }

        // T, R, U, D
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int[] item: numList){
            int x = item[1], y = item[2];

            for(int[] dir: dirs){
                int i = x + dir[0], j = y + dir[1];

                if (i < 0 || i >= row || j < 0 || j >= col || matrix[i][j] <= matrix[x][y]) {
                    continue;
                }

                dp[x][y] = Math.max(dp[x][y], dp[i][j] + 1);
            }

            max = Math.max(max, dp[x][y]);
        }

        return max;
    }
}
