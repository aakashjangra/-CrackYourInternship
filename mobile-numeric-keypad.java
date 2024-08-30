// Problem link - https://www.geeksforgeeks.org/problems/mobile-numeric-keypad5456/1

class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    Long[][][] memo;
    public long getCount(int n) {
        int[][] keypad = new int[4][3];
        memo = new Long[4][3][n];
        
        for(int i = 0; i < 4; i++){
            Arrays.fill(keypad[i], 1);
        }
        
        // prohibited buttons
        keypad[3][0] = 0;
        keypad[3][2] = 0;
        
        long total = 0;
        
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                if(keypad[i][j] == 1){
                    total += countSequences(i, j, n - 1, keypad);
                }
            }
        }
        
        return total;
    }
    
    private long countSequences(int i, int j, int n, int[][] valid){
        if(n == 0) return 1;
        
        if(memo[i][j][n] != null) return memo[i][j][n];
        
        long count = 0;
        
        //stay on the same key
        count += countSequences(i, j, n - 1, valid);
        
        //press a key that is Left, Right, Up, Down
        for(int[] dir: dirs){
            int x = dir[0] + i, y = dir[1] + j;
            if(x >= 0 && x < 4 && y >= 0 && y < 3 && valid[x][y] == 1){
                count += countSequences(x, y, n - 1, valid);
            }
        }
        
        return memo[i][j][n] = count;
    }
}
