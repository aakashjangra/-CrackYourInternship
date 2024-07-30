// Problem link - https://leetcode.com/problems/spiral-matrix/

// TC - O(m * n)
// SC - O(1)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> spiral  = new ArrayList<>();
        int levels = (Math.min(m, n) + 1)/ 2;

        for(int level = 1; level <= levels; level++){
            int topRow = level - 1;
            int rightCol = n - level;
            int bottomRow = m - level;
            int leftCol = level - 1;

            // top row
            for(int j = leftCol; j <= rightCol; j++){
                spiral.add(matrix[topRow][j]);
            }
            // right column
                for(int i = topRow + 1; i <= bottomRow - 1; i++){
                    spiral.add(matrix[i][rightCol]);
                }
                // bottom row
            if(topRow != bottomRow){
                for(int j = rightCol; j >= leftCol; j--){
                    spiral.add(matrix[bottomRow][j]);
                }
            }

            // left column
            if(leftCol != rightCol){
                for(int i = bottomRow - 1; i >= topRow + 1; i--){
                    spiral.add(matrix[i][leftCol]);
                }
            }
        }

        return spiral;
    }
}
