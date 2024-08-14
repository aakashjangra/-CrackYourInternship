// Problem link - https://www.geeksforgeeks.org/problems/permutations-in-array1747/1

// TC - O(n log n)
// SC - O(1)
class Solution {
    public boolean isPossible(int k, int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        int n = arr1.length;
        
        for(int i = 0; i < n; i++){
            if(arr1[i] + arr2[n - i - 1] < k) return false; 
        }
        
        return true;
    }
}
