// Problem link - https://leetcode.com/problems/find-eventual-safe-states/

// TC - O(V log V + E)
// SC - O(V)
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        int[] outDegree = new int[n];

        for(int i = 0; i < n; i++){
            outDegree[i] = graph[i].length;
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                dfs(i, vis, outDegree, graph);
            }
        }

        for(int i = 0; i < n; i++){
            if(outDegree[i] == 0) ans.add(i);
        }

        Collections.sort(ans);
        return ans;
    }
    private void dfs(int node, int[] vis, int[] outDegree, int[][] graph){
        vis[node] = 1;

        for(int adj: graph[node]){
            if(vis[adj] == 0){
                dfs(adj, vis, outDegree, graph);
            }

            if(outDegree[adj] == 0) outDegree[node]--;
        }
    }
}
