// Problem link - https://leetcode.com/problems/number-of-operations-to-make-network-connected/

class Solution {
    public int makeConnected(int n, int[][] conn) {
        if(conn.length < n - 1) return -1;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] c: conn){
            graph.get(c[0]).add(c[1]);
            graph.get(c[1]).add(c[0]);
        }

        int components = 0;
        boolean[] vis = new boolean[n];
        for(int v = 0; v < n; v++){
            components += dfs(v, graph, vis);
        }

        return components - 1;
    }
    private int dfs(int u, List<List<Integer>> graph, boolean[] vis){
        if(vis[u]) return 0;
        vis[u] = true;
        for(int v: graph.get(u)){
            dfs(v, graph, vis);
        }
        return 1;
    }
}
