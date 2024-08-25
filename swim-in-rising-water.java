// Problem link - https://leetcode.com/problems/swim-in-rising-water/

class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    // an alternative to declare class
    record Point(int x, int y){} 
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        // sort by less depth
        PriorityQueue<Point> q = new PriorityQueue<>((a,b) -> 
            grid[a.x][a.y] - grid[b.x][b.y]
        );

        HashSet<Point> visited = new HashSet<>();

        Point start = new Point(0, 0);
        Point end = new Point(n - 1, n - 1);

        q.offer(start);
        visited.add(start);

        int level = grid[0][0];
        while(q.size() > 0){
            Point cur = q.poll();

            level = Math.max(level, grid[cur.x][cur.y]);
            if(cur.equals(end)) return level;

            for(int[] dir: dirs){
                int x = cur.x + dir[0], y = cur.y + dir[1];

                if(x >= 0 && x < n && y >= 0 && y < n){
                    Point next = new Point(x, y);
                    if(visited.contains(next)) continue;
                    visited.add(next);
                    q.offer(next);
                }
            }
        }

        return -1;
    }
}
