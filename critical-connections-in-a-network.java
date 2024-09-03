// Problem link - https://leetcode.com/problems/critical-connections-in-a-network/

class Solution {
    int[] disc, low;
    int time = 1;
    List<List<Integer>> ans;
    Map<Integer,List<Integer>> graph;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph = new HashMap<>();
        ans = new ArrayList<>();
        disc = new int[n];
        low = new int[n];
        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(List<Integer> c: connections){
            graph.get(c.get(0)).add(c.get(1));
            graph.get(c.get(1)).add(c.get(0));
        }

        dfs(0, -1);
        return ans;
    }

    private void dfs(int node, int prev){
        disc[node] = low[node] = time++;
        for(int adj: graph.get(node)){
            if(disc[adj] == 0){
                dfs(adj, node);
                low[node] = Math.min(low[node], low[adj]);
            } else if(adj != prev){
                low[node] = Math.min(low[node], disc[adj]);
            } 
            
            if(low[adj] > disc[node]){
                ans.add(Arrays.asList(node, adj));
            }
        }
    }
}
