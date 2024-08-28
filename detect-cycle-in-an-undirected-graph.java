// Problem link - https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

// TC - O(V + E)
// SC - O(V)
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                //if not visited, run dfs
                boolean cycle = dfs(i, -1, adj, vis);
                if(cycle) return true; // cycle exists
            }
        }
        
        return false;
    }
    
    private boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] vis){
        vis[node] = 1; //marked visited
        
        for(int neigh: adj.get(node)){
            if(neigh != parent && vis[neigh] == 1){ //cycle found
                return true;
            }
            
            if(vis[neigh] == 1) continue; 
            
            boolean cycle = dfs(neigh, node, adj, vis);
            if(cycle) return true;
        }
        
        return false;
    }
}
