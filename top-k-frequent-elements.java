// Problem link - https://leetcode.com/problems/top-k-frequent-elements/

// TC - O(n log k)
// SC - O(n)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> 
            Integer.compare(freq.get(a), freq.get(b))
        );

        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for(int num: freq.keySet()){
            minHeap.offer(num);

            if(minHeap.size() > k) minHeap.poll();
        }

        int[] ans = new int[k];
        while(minHeap.size() > 0){
            int indx = minHeap.size() - 1;
            ans[indx] = minHeap.poll();
        }

        return ans;
    }
}
