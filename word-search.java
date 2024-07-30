// Problem link - https://leetcode.com/problems/word-search/

// TC - O(m * n * 4L) - L is the length of word
// SC - O(1) - not including recursion stack space here

class Solution {
    int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(find(i, j, 0, board, word)) return true;
                }
            }
        }

        return false;
    }
    public boolean find(int i, int j, int pos, char[][] board, String word){
        if(pos == word.length()) return true;

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '*' || board[i][j] != word.charAt(pos)){
            return false;
        }

        char original = board[i][j];
        board[i][j] = '*';

        // 4 directions - TRBL
        for(int[] dir: dirs){
            int x = i + dir[0], y = j + dir[1];

            if(find(x, y, pos + 1, board, word)){
                board[i][j] = original;
                return true;
            }
        }

        board[i][j] = original;

        return false;
    }
}
