// Problem link - https://www.geeksforgeeks.org/problems/negative-weight-cycle3504/1

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        if(n == 0 || edges.length == 0) return 0;
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        int src = edges[0][0];
        
        dist[src] = 0; // let's assume 0 as src
        
        // Bellman ford
        //n - 1 times
        for(int i = 0; i < n - 1; i++){
            for(int[] edge: edges){
                int u = edge[0], v = edge[1], w = edge[2];
                
                if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }
        
        //check for neg cycle
            for(int[] edge: edges){
                int u = edge[0], v = edge[1], w = edge[2];
                
                //if this is true even once, there is a negative cycle
                if(dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                    return 1; //neg cycle found
                }
            }
        
        return 0;


}
}
