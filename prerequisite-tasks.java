// Problem link - https://www.geeksforgeeks.org/problems/prerequisite-tasks/1

class Solution {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        int[] inDegree = new int[N];
        int k = 0;
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < P; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            
            graph.get(v).add(u);
            inDegree[u]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }
        
        //topo sort
        int count = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            count++;
            for(int neigh: graph.get(cur)){
                inDegree[neigh]--;
                if(inDegree[neigh] == 0){
                    q.offer(neigh);
                }
            }
        }
        
        return count == N;
    }
    
}
