// Problem link - https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1

// TC - O(log n)
// SC - O(1)
class Solution {

    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long x) {
        int l = 0, r = n - 1;
        int ans = -1;
        
        while(l <= r){
            int mid = (l + r)/2;
            
            if(arr[mid] == x){
                return mid;
            } else if(arr[mid] < x){
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return ans;
    }
}
