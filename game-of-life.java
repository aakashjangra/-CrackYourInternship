// Problem link - https://leetcode.com/problems/game-of-life/


// TC - O(n * m)
// SC - O(n * m)
class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] ans = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int score = findScore(i, j, n, m, board);
                //live cell
                if(board[i][j] == 1){
                    if(score < 2 || score > 3){
                        ans[i][j] = 0;
                    } else {
                        ans[i][j] = 1;
                    }
                } else {
                    if(score == 3){
                        ans[i][j] = 1;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] = ans[i][j];
            }    
        }
    }

    // check all eight neighbors 
    final int[][] dirs = {{-1, 0}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}, {1, 0}, {1, -1}, {1, 1}};

    private int findScore(int i, int j, int n, int m, int[][] board){

        int score = 0;

        for(int[] dir: dirs){
            int x = i + dir[0], y = j + dir[1];

            if(x >= 0 && x < n && y >= 0 && y < m){
                score += board[x][y];
            }
        }

        return score;
    }
}
