// Problem link - https://leetcode.com/problems/time-needed-to-inform-all-employees/

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int[] timeTaken = new int[n];
        //make graph
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for(int i = 0; i < n; i++){
            if(manager[i] != -1){
                graph.get(manager[i]).add(new int[]{i, informTime[i]});
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        Arrays.fill(timeTaken, Integer.MAX_VALUE);
        q.offer(headID);
        timeTaken[headID] = informTime[headID];

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int[] employeeArr: graph.get(cur)){
                int employee = employeeArr[0], time = employeeArr[1];
                if(timeTaken[cur] + time < timeTaken[employee]){
                    q.offer(employee);
                    timeTaken[employee] = timeTaken[cur] + time;
                }
            }
        }

        int maxTime = 0;
        for(int time: timeTaken){
            if(maxTime < time) maxTime = time;
        }
        return maxTime;
    }
}
