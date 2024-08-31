// Problem link - https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1

class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                dfs(i, adj, st, vis);
            }
        }
        
        ArrayList<ArrayList<Integer>> rev=new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < V; i++){
            rev.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < V; i++){
            for(int u: adj.get(i)){
                rev.get(u).add(i);
            }
        }
        
        int count = 0;
        Arrays.fill(vis, false);
        
        while(!st.isEmpty()){
            int u = st.pop();
            Queue<Integer> q = new ArrayDeque<>();
            if(!vis[u]){
                count++;
                q.add(u);
                vis[u] = true;
            }
            
            while(!q.isEmpty()){
                int v = q.poll();
                for(int a: rev.get(v)){
                    if(!vis[a]){
                        vis[a] = true;
                        q.add(a);
                    }
                }
            }
        }
        
        return count;
    }
    
    void dfs(int s, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, boolean[] visited){
                               
        visited[s] = true;
        for(int u: adj.get(s)){
            if(!visited[u]){
                dfs(u,adj,st,visited);
            }
        }
        
        st.push(s);
    }
}
