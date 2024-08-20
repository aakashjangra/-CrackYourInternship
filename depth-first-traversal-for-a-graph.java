// Problem link - https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

// TC - O(V + E)
// SC - O(V)
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(0, adj, vis, ans);
        
        return ans;
    }
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, ArrayList<Integer> traversal){
        if(vis[node] == 1) return;
        
        vis[node] = 1;
        traversal.add(node);
        
        for(int neigh: adj.get(node)){
            if(vis[neigh] != 1){
                dfs(neigh, adj, vis, traversal);
            }
        }
    }
}
