// Problem link - https://www.geeksforgeeks.org/problems/topological-sort/1

// TC - O(V + E)
// SC - O(V)
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        boolean vis[] = new boolean[V];
        int[] ordering = new int[V];
        
        int i = V - 1;
        
        for(int at = 0; at < V; at++){
            if(vis[at] == false){
                ArrayList<Integer> visitedNodes = new ArrayList<>();
                dfs(at, vis, visitedNodes, adj);
                for(int nodeId: visitedNodes){
                    ordering[i] = nodeId;
                    i--;
                }
            }
        }
        
        return ordering;
    }
    
    static void dfs(int at, boolean[] vis, ArrayList<Integer> visitedNodes, ArrayList<ArrayList<Integer>> graph){
        vis[at] = true;
        
        for(int adj: graph.get(at)){
            if(vis[adj] == false){
                dfs(adj, vis, visitedNodes, graph);
            }
        }
        
        visitedNodes.add(at);
    }
}
