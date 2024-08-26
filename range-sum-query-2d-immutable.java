// Problem link - https://leetcode.com/problems/range-sum-query-2d-immutable/

class NumMatrix {
    int[][] mat;
    public NumMatrix(int[][] matrix) {
        this.mat = matrix;
        int n = mat.length;
        int m = mat[0].length;
        for(int i = 0; i < n; i++){
            for(int j=0 ; j < m ; j++){
                if(i + 1 < n){
                    mat[i+1][j] += mat[i][j]; 
                }
                if(j != 0){
                    mat[i][j] += mat[i][j-1]; 
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int rs = 0;
        if(row1 == 0){
            if(col1 == 0){
                rs = mat[row2][col2];
            } else {
                rs = mat[row2][col2] - mat[row2][col1 - 1];
            }
        } else {
            if(col1 == 0){
                rs = mat[row2][col2] - mat[row1 - 1][col2];
            } else {
                rs = (mat[row2][col2] - mat[row2][col1 - 1]) - (mat[row1 - 1][col2] - mat[row1 - 1][col1 - 1]);
            }
        }

        return rs;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
