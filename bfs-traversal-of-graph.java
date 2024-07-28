// Problem link - https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

// TC - O(V + E)
// SC - O(V)
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        int[] vis = new int[V];
        
        ArrayList<Integer> bfs = new ArrayList<>();
        
        q.offer(0);
        vis[0] = 1;
        
        while(q.size() > 0){
            int node = q.poll();
            
            bfs.add(node);
            
            for(int neighbor: adj.get(node)){
                if(vis[neighbor] == 0){
                    //unvisited, visit it and mark visited
                    q.offer(neighbor);
                    vis[neighbor] = 1; //marked visited
                }
            }
        }
        
        return bfs;
    }
}
