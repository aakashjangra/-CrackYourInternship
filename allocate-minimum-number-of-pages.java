// Problem link - https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1

// TC - O(n log sum) - sum is the sum of arr elements/totalPages
// SC - O(1)
class Solution {
    // Function to find minimum number of pages.
    public static long findPages(int n, int[] arr, int m) {
        if(n < m) return -1;
        
        int l = arr[0], r = 0;
        
        for(int i = 0; i < n; i++){
            // we want l to be highest element of arr
            if(arr[i] > l){
                l = arr[i];
            } 
            r += arr[i];
        }
        
        while(l <= r){
            int mid = (l + r)/2;
            int students = countStudents(arr, mid);
            if(students > m){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return l;
    }
    
    private static int countStudents(int[] arr, int target){
        long count = 0;
        int m = 1;
        
        for(int pages: arr){
            if(count + pages <= target){
                count += pages;
            } else {
                m += 1;
                count = pages;
            }
        }
        
        return m;
    }
};
