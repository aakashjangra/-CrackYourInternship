// Problem link - https://www.geeksforgeeks.org/problems/replace-os-with-xs0052/1

// TC - O(n * m)
// SC - O(n * m)
class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        // up, down, left, right
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        
        // mark all boundary 'O's -> 'Z'
        for(int i = 0; i < n; i++){
            if(a[i][0] == 'O') q.offer(new int[]{i, 0});
            if(a[i][m - 1] == 'O') q.offer(new int[]{i, m - 1});
        }
        
        for(int j = 0; j < m; j++){
            if(a[0][j] == 'O') q.offer(new int[]{0, j});
            if(a[n - 1][j] == 'O') q.offer(new int[]{n - 1, j});
        }
        
        // mark all 'O' connected with boundary 'O' as 'Z', as they can't be converted to 'X' ( they are not surrounded by X)
        while(q.size() > 0){
            int[] coord = q.poll();
            int i = coord[0], j = coord[1];
            
            a[i][j] = 'Z';
            
            for(int[] dir: dirs){
                int x = dir[0] + i, y = dir[1] + j;
                
                //if valid add to queue
                if(x >= 0 && x < n && y >= 0 && y < m && a[x][y] == 'O'){
                    q.offer(new int[]{x, y});
                }
            }
        }
        
        // convert 'O' -> 'X' 
        // and 'Z' -> 'O'
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] == 'O'){
                    a[i][j] = 'X';
                } else if(a[i][j] == 'Z'){
                    a[i][j] = 'O';
                }
                
            }
        }
        
        return a;
    }
}
