// Problem link - https://www.geeksforgeeks.org/problems/max-rectangle/1

// TC - O(n * m)
// SC - O(m)
class Solution {
    public int maxArea(int mat[][], int n, int m) {
       int[] temp = new int[m];
       int max = 0;
       for(int i = 0; i < n; i++){
           for(int j = 0; j < m; j++){
               if(mat[i][j] == 0){
                   temp[j] = 0;
               } else {
                   temp[j] = mat[i][j] + temp[j];
               }
           }
           
           max = Math.max(helper(temp, m), max);
       }
       
       return max;
    }
    
    private int helper(int[] arr, int n){
        int res = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i <= n; i++){
            while(!st.isEmpty() && (i == n || arr[i] <= arr[st.peek()])){
                int height = arr[st.pop()];
                int width;
                if(st.isEmpty()){
                    width = i;
                } else{
                    width = i - st.peek() - 1;
                }
                
                res = Math.max(res, height * width);
            }
            
            st.push(i);
        }
        
        return res;
    }
}
