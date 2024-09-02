// Problem link - https://leetcode.com/problems/evaluate-division/

class Solution {
    class Edge {
        String v;
        double value;
        
        public Edge (String v, double value) {
            this.v = v;
            this.value = value;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        Map<String, List<Edge>> map = new HashMap<>();
        
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get (i);
            addEdge(map, equation.get(0), equation.get(1), values[i]);
            addEdge(map, equation.get(1), equation.get(0), 1 / values[i]);
        }

        int i = 0;
        for(List<String> query: queries){
            ans[i++] = dfs(map, new HashSet<>(), query.get(0), query.get(1));
        }
        
        return ans;
    }
    private void addEdge(Map<String, List<Edge>> map, String u, String v, double value) {
        if(!map.containsKey(u)){
            map.put(u, new ArrayList<>());
        }

        map.get(u).add(new Edge(v, value));
    }
    private double dfs(Map<String, List<Edge>> map, Set<String> set, String u, String v) {
        if(!map.containsKey(u) || !map.containsKey(v)) return -1;
        if(u.equals(v)) return 1;

        for(Edge edge: map.get(u)){
            if(set.contains(edge.v)) continue;

            if(edge.v.equals(v)) return edge.value;

            set.add(u);
            double val = dfs(map, set, edge.v, v);
            if(val != -1) return val * edge.value;
        }

        return -1;
    }
}
