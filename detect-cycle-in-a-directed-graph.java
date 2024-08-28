// Problem link - https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

// TC - O(V + E)
// SC - O(V)
class Solution {
    int[] vis;
    int[] pathVis;
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        vis = new int[V];
        pathVis = new int[V];
        
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                //not visited 
                boolean cycle = dfs(i, adj);
                if(cycle) return true;
            }
        }
        
        return false;
    }
    
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        pathVis[node] = 1;
        
        for(int neigh: adj.get(node)){
            if(pathVis[neigh] == 1) return true; //cycle found
            if(vis[neigh] == 1) continue;
            
            boolean cycle = dfs(neigh, adj);
            if(cycle) return true;
        }
        
        pathVis[node] = 0;
        return false;
    }
}
