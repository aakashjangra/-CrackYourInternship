// Problem link - https://leetcode.com/problems/redundant-connection/

class Solution {
    int[] par;
    public int[] findRedundantConnection(int[][] edges) {
        par = new int[edges.length + 1];

        for(int i = 0; i < par.length; i++){
            par[i] = i;
        }

        for(int[] e: edges){
            if(find(e[0]) == find(e[1])) return e;

            union(e[0], e[1]);
        }

        return new int[]{-1, -1};
    }

    private int find(int node){
        while(par[node] != node){
            node = par[node];
        }

        return node;
    }

    private void union(int i, int j){
        int a = find(i);
        int b = find(j);

        if(a != b){
            par[b] = a;
        }
    }
}
