// Problem link - https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

class Solution {
    ArrayList<String> ans;
    public ArrayList<String> findPath(int[][] mat) {
        ans = new ArrayList<>();
        
        helper(0, 0, new StringBuilder(), mat);
        
        return ans;
    }
    private void helper(int i, int j, StringBuilder path, int[][] mat){
        int n = mat.length;
        if(i < 0 || j < 0 || i >= n || j >= n || mat[i][j] == 0) return;
        
        if(i == n - 1 && j == n - 1) {
            ans.add(path.toString());
            return;
        }
        
        int orig = mat[i][j];
        
        mat[i][j] = 0; //marking visited
        
        // L - {0, -1}
        path.append("L");
        helper(i, j - 1, path, mat);
        path.deleteCharAt(path.length() - 1);
        // R - {0, 1}
        path.append("R");
        helper(i, j + 1, path, mat);
        path.deleteCharAt(path.length() - 1);
        
        // U - {-1, 0}
        path.append("U");
        helper(i - 1, j, path, mat);
        path.deleteCharAt(path.length() - 1);
        
        // D - {1, 0}
        path.append("D");
        helper(i + 1, j, path, mat);
        path.deleteCharAt(path.length() - 1);
        
        mat[i][j] = orig; // returning to original state
    }
}
