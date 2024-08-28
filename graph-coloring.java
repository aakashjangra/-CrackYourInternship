// Problem link - https://www.geeksforgeeks.org/graph-coloring-applications/

class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int colors[] = new int[n]; // 0 means no color is assigned
        
        if(solve(graph, m, colors, 0, n)){
            return true;
        } 
        
        return false;
    }
    
    private boolean solve(boolean graph[][], int m, int colors[], int v, int n){
        if(v == n) return true;
        
        for(int c = 1; c <= m; c++){
            if(isSafe(graph, v, colors, c, n)){
                colors[v] = c;
                if(solve(graph, m, colors, v + 1, n)){
                    return true;
                }
                
                colors[v] = 0;
            }
        }
        
        return false;
    }
    
    private boolean isSafe(boolean graph[][], int v, int[] colors, int c, int n){
        for(int i = 0; i < n; i++){
            if(graph[v][i] && c == colors[i]){
                return false;
            }
        }
        
        return true;
    }
}
