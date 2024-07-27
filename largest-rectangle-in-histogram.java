// Problem link - https://leetcode.com/problems/largest-rectangle-in-histogram/

// TC - O(n)
// SC - O(n)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] boundaryLeft = new int[n]; 
        int[] boundaryRight = new int[n]; 
        Stack<Integer> index = new Stack<>();

// finding left boundary
        for(int i = 0; i < n; i++){
            
            // remove elements till a smaller element is found
            while(index.size() > 0 && heights[index.peek()] >= heights[i]){
                index.pop();
            }

            if(index.isEmpty()){
                boundaryLeft[i] = -1;
            } else {
                boundaryLeft[i] = index.peek();
            }

            index.push(i);
        }

        index.clear();
        // finding right boundary
        for(int i = n - 1; i >= 0; i--){
            
            // remove elements till a smaller element is found
            while(index.size() > 0 && heights[index.peek()] >= heights[i]){
                index.pop();
            }

            if(index.isEmpty()){
                boundaryRight[i] = n;
            } else {
                boundaryRight[i] = index.peek();
            }

            index.push(i);
        }

        // find maxArea using boundaries
        int maxArea = 0;

        for(int i = 0; i < n; i++){
            int area = heights[i] * (boundaryRight[i] - boundaryLeft[i] - 1);

            maxArea = Math.max(maxArea, area);
        }


        return maxArea;
    }
}
