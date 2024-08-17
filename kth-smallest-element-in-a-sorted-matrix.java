// Problem link - https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

// TC - O(N*N*log k)
// SC - O(K)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                maxHeap.offer(matrix[i][j]);

                if(maxHeap.size() > k) maxHeap.poll();
            }
        }

        return maxHeap.peek();
    }
}
