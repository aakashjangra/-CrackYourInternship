// Problem link - https://leetcode.com/problems/reorganize-string/

// TC - O(N log K)
// SC - O(log K), k is the no. of unique characters in string s
class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap();
        int n = s.length();
        for(int i = 0; i < n; i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        for(int freq: map.values()){
            if(freq > (n + 1) / 2) return ""; //not feasible
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(map.get(b),map.get(a)));  
        maxHeap.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();
        char prev = '*';

        while(!maxHeap.isEmpty()){
            char cur = maxHeap.poll();
            sb.append(cur);
            map.put(cur, map.get(cur) - 1);
            if(prev != '*' && map.get(prev) > 0){
                maxHeap.offer(prev);
            }
            prev = cur;
        }

        if(sb.length() != n) return "";

        return sb.toString();
    }
}
