// Problem link - https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/

// TC - O(N)
// SC - O(N)
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int pair[] : adjacentPairs) {
            int u = pair[0];
            int v = pair[1];

            if (!graph.containsKey(u))
                graph.put(u, new ArrayList<>());
            if (!graph.containsKey(v))
                graph.put(v, new ArrayList<>());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        List<Integer> ans = new ArrayList<>();

        for (int src : graph.keySet()) {
            if (graph.get(src).size() == 1) {
                helper(src, graph, new HashSet<>(), ans);
                break;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    public void helper(int src, HashMap<Integer, List<Integer>> graph, HashSet<Integer> vis, List<Integer> ans) {
        if(vis.contains(src)) return;

        ans.add(src);
        vis.add(src);
        for(int adj: graph.get(src)){
            helper(adj, graph, vis, ans);
        }
    }
}
