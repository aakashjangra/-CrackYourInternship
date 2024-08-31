// Problem link - https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/

class Solution {
    Map<Integer, Integer> map;
    int islands;
    public int removeStones(int[][] stones) {
        islands = 0;
        map = new HashMap<>();

        for(int i = 0; i < stones.length; i++){
            union(stones[i][0], ~stones[i][1]);
        }

        return stones.length - islands;
    }

    private int find(int x){
        if(map.putIfAbsent(x, x) == null){
            islands++;
        }
        if(x != map.get(x)){
            map.put(x, find(map.get(x)));
        }
        return map.get(x);
    }

    private void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            map.put(x, y);
            islands--;
        }
    }
}
