// Problem link - https://leetcode.com/problems/rotate-image/

// TC - O(n * n)
// SC - O(1)
// Approach 1
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverese rows
        for(int i = 0; i < n; i++){
            // reverse ith row
            for(int j = 0; j < n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}

// TC - O(n * n)
// SC - O(1)
// Approach 2
class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length;
        int levels = n/2;

        for(int level = 0; level < levels; level++){
            for(int i = level; i < n - 1 - level; i++){
                //swap 4 elements
                int temp = mat[level][i];
                mat[level][i] = mat[n - 1 - i][level];
                mat[n - 1 - i][level] = mat[n - 1 - level][n - 1 - i];
                mat[n - 1 - level][n - 1 - i] = mat[i][n - 1 - level];
                mat[i][n - 1 - level] = temp;
            }
        }
    }
}
