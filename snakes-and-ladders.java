// Problem link - https://leetcode.com/problems/snakes-and-ladders/

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int moves = 0;
        boolean[][] vis = new boolean[n][n];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        vis[n - 1][0] = true;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int val = q.poll();
                if(val == n * n){
                    return moves;
                }

                for(int diceVal = 1; diceVal <= 6; diceVal++){
                    if(val + diceVal > n * n) break;
                    int[] pos = findCoordinates(val + diceVal, n);
                    int r = pos[0], c = pos[1];
                    if(!vis[r][c]){
                        vis[r][c] = true;
                        if(board[r][c] == -1){
                            q.add(val + diceVal);
                        } else 
                        {
                            q.add(board[r][c]);
                        }
                    }
                }
            }

            moves++;
        }

        return -1;
    }
    private int[] findCoordinates(int cur, int n){
        int r = n - (cur - 1) / n - 1;
        int c = (cur - 1) % n;
        if(r % 2 == n % 2){
            return new int[]{r, n - 1 - c};
        } else {
            return new int[]{r, c};
        }
    }
}
