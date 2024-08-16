// Problem link - https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

// TC - O(n log n)
// SC - O(n)
class Solution {
    private void makeHeap(int r, int c, TreeNode root, PriorityQueue<int[]> minHeap){
        if(root == null) return;

        minHeap.add(new int[]{r, c, root.val});

        makeHeap(r + 1, c - 1, root.left, minHeap);
        makeHeap(r + 1, c + 1, root.right, minHeap);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // sort by col (asc)
        // sort by row (asc)
        // sort by value (asc)
        PriorityQueue<int []> minHeap = new PriorityQueue<>(
        (a,b) -> 
        a[1] != b[1]? a[1] - b[1]: 
        a[0] != b[0]? a[0] - b[0]: 
        a[2] - b[2]
        );

        makeHeap(0, 0, root, minHeap);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> colList = new ArrayList<>();
        int[] first = minHeap.poll();
        int prevCol = first[1];
        colList.add(first[2]);

        while(!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            int r = cur[0], c = cur[1], v = cur[2];

            if(c == prevCol){
                colList.add(v);
            } else {
                ans.add(colList);
                colList = new ArrayList<>();
                colList.add(v);
            }

            prevCol = c;
        }

        ans.add(colList);

        return ans;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
