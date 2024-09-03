// Problem link - https://www.geeksforgeeks.org/problems/total-number-of-spanning-trees-in-a-graph/1

class Solution {
    public static int countSpanningTrees(int[][] edges,int n,int m) {
        int[][] graph = new int[n][n];
        for(int[] e: edges){
            int u = e[0], v = e[1];
            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        // find degree of every node
        int[] degree = new int[n];
        int[][] grid = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(graph[i][j] == 1){
                    degree[i]++;
                }
            }
        }
        
        // replace diagonals with degree and mark other as -1 except 0
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j){
                    //diagonal
                    grid[i][j] = degree[i];
                } else if(graph[i][j] != 0){
                    grid[i][j] = -1;
                }
            }
        }
        
        // cofactor of any diagonal/node
        return findDeterminant(getSubMatrix(grid, 0, 0));
    }
    
    public static int findDeterminant(int[][] matrix) {
        int n = matrix.length;

        // Base case for 1x1 matrix
        if (n == 1) {
            return matrix[0][0];
        }

        // Base case for 2x2 matrix
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        // Initialize the determinant
        int determinant = 0;

        // Loop through the first row and compute the determinant recursively
        for (int i = 0; i < n; i++) {
            // Create a submatrix by excluding the current row and column
            int[][] subMatrix = getSubMatrix(matrix, 0, i);

            // Recursive call to find the determinant of the submatrix
            determinant += Math.pow(-1, i) * matrix[0][i] * findDeterminant(subMatrix);
        }

        return determinant;
    }
    
    // Helper function to create a submatrix by removing the specified row and column
    public static int[][] getSubMatrix(int[][] matrix, int excludingRow, int excludingCol) {
        int n = matrix.length;
        int[][] subMatrix = new int[n - 1][n - 1];
        int r = -1;

        for (int i = 0; i < n; i++) {
            if (i == excludingRow)
                continue;
            r++;
            int c = -1;
            for (int j = 0; j < n; j++) {
                if (j == excludingCol)
                    continue;
                subMatrix[r][++c] = matrix[i][j];
            }
        }

        return subMatrix;
    }
}
       
