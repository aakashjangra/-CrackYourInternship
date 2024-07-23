//Problem link - https://leetcode.com/problems/set-matrix-zeroes/

// TC - O(m * n)
// SC - O(1); (in-place)
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowContainsZero = false,  firstColumnContainsZero = false;

        int m = matrix.length, n = matrix[0].length;

        //first row zero check
        for(int j = 0; j < n; j++){
            if(matrix[0][j] == 0) {
                firstRowContainsZero = true;
                break;
            }
        }

        //first column zero check
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0) {
                firstColumnContainsZero = true;
                break;
            }
        }

        //set first row and column zero, if zero is encountered in a cell
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        //iterate over first row and make the whole column zero if zero is found
        for(int j = 1; j < n; j++){
            if(matrix[0][j] == 0){
                //put zero in entire column
                for(int i = 1; i < m; i++){
                    matrix[i][j] = 0;
                }
            }
        }

         //iterate over first column and make the whole row zero if zero is found
        for(int i = 1; i < m; i++){
            if(matrix[i][0] == 0){
                //put zero in entire row
                for(int j = 1; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        //if first row contained zero originally, then make entire first row zero
        if(firstRowContainsZero){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }
        //if first col contained zero originally, then make entire first col zero
        if(firstColumnContainsZero){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
