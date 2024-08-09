// problem link - https://www.geeksforgeeks.org/problems/the-celebrity-problem/1

// TC - O(N)
// SC - O(1)

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        int n = mat.length;
        
        int a = 0, b = n - 1;
        
        while(a < b){
            if(mat[a][b] == 1){
                a++;
            } else {
                b--;
            }
        }
        
        // verify celebrity a
        for(int i = 0; i < n; i++){
            if(i != a && (mat[i][a] == 0 || mat[a][i] == 1)) return -1;
        }
        
        return a;
    }
}
