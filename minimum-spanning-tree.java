// Problem link - https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1

class Solution {
    static class Node{
        int u;
        int v;
        int weight;
        Node(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.weight = w;
        }
    }
    
    static int find(int a, int[] parent){
        while(parent[a] != a){
            a = parent[a];
        }
        
        return a;
    }
    static boolean union(int a, int b, int[] par){
        int i = find(a, par);
        int j = find(b, par);
        
        if(i == j) return false;
        
        par[i] = j;
        
        return true;
    }
    
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        boolean []vis = new boolean[V];
        int[] par = new int[V];
        for(int i = 0; i < V; i++){
            par[i] = i;
        }
        PriorityQueue<Node> q = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        
        for(int i = 0; i < V; i++){
            for(int[] arr: adj.get(i)){
                q.offer(new Node(i, arr[0], arr[1]));
            }
        }
        
        int sum = 0;
        int edge = V - 1;
        while(edge > 0){
            Node cur = q.poll();
            if(union(cur.u, cur.v, par)){
                edge--;
                sum += cur.weight;
            }
        }
        
        return sum;
    }
}
