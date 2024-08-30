// Problem link - https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1

class Solution
{
    public void shortest_distance(int[][] mat)
    {
        int n = mat.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == -1){
                    mat[i][j] = Integer.MAX_VALUE;
                }
                if(i == j){
                    mat[i][j] = 0;
                }
            }
        }
        
        for(int v = 0; v < n; v++){
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++){
                    if(mat[i][v] != Integer.MAX_VALUE && mat[v][j] != Integer.MAX_VALUE){
                        mat[i][j] = Math.min(mat[i][j], (mat[i][v] + mat[v][j]));
                    }
                }
            }
        }
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(mat[i][j] == Integer.MAX_VALUE)
                  mat[i][j] = -1;
            }
        }
    }
}
