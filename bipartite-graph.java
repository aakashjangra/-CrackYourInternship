// Problem link - https://www.geeksforgeeks.org/problems/bipartite-graph/1

class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        Queue<Integer> q = new ArrayDeque<>();
        int[] color = new int[V];
        Arrays.fill(color, -1);
        
        for(int i = 0; i < V; i++){
            if(color[i] == -1){
                
                q.add(i);
                color[i] = 0;
                
                while(!q.isEmpty()){
                    int node = q.poll();
                    for(int neigh: adj.get(node)){
                        if(color[neigh] == -1){
                            color[neigh] = (color[node] + 1) % 2;
                            q.add(neigh);
                        } else {
                            if(color[neigh] == color[node]) return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
