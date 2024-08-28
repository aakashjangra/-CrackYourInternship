// Problem link - https://leetcode.com/problems/maximal-rectangle/

class Solution {
    class Pair{
        int r;
        int c;
        Pair(int _r, int _c){
            this.r = _r;
            this.c = _c;
        }
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        Pair[][] data = new Pair[n][m]; 

        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                if(matrix[i][j] == '1'){
                    int r = i < n-1? 1 + data[i+1][j].r: 1;
                    int c = j < m-1? 1 + data[i][j+1].c: 1;

                    data[i][j] = new Pair(r, c);
                } else {
                    data[i][j] = new Pair(0, 0);
                }
            }
        }

        int maxArea = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                Pair pair = data[i][j];

                int r = pair.r, c = pair.c;

                for(int x = i; x < i+r; x++){
                    int col = data[x][j].c;

                    c = Math.min(c, col);

                    maxArea = Math.max(maxArea, c * (x - i + 1));
                }
            }
        }

        return maxArea;
    }
}
