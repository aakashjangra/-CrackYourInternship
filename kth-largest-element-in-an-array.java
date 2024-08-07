// Problem link - https://leetcode.com/problems/kth-largest-element-in-an-array/

// TC - O(n log k)
// SC - O(k)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num: nums){
            minHeap.offer(num);

            if(minHeap.size() > k){
                //remove the smallest (smallest will be on top)
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
