// Problem link - https://leetcode.com/problems/sum-of-distances-in-tree/

// TC - O(n)
// SC - O(n)
class Solution {
    List<List<Integer>> graph;
    int[] ans, count;
    int N;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.N = n;
        graph = new ArrayList<>();
        ans = new int[N];
        count = new int[N];
        Arrays.fill(count, 1);

        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(0, -1);
        dfs2(0, -1);

        return ans;
    }

    private void dfs(int node, int parent){
        for(int child: graph.get(node)){
            if(child != parent){
                dfs(child, node);
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
        }
    }
    
    private void dfs2(int node, int parent){
        for(int child: graph.get(node)){
            if(child != parent){
                ans[child] = (ans[node] - count[child]) + (N - count[child]);
                dfs2(child, node);
            }
        }
    }
}
