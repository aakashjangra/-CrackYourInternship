// Problem link - https://www.geeksforgeeks.org/check-reversing-sub-array-make-array-sorted/

// TC - O(n)
// SC - O(1)
static boolean sortArr(int[] arr, int n) 
{ 
        int front = 0;
        
        for(int i = 0; i < n - 1; i++){
            if(arr[i] > arr[i + 1]){
                front = i;
                break;
            }
        }
        
        int back = n - 1;
        
        for(int i = n - 1; i > 0; i--){
            if(arr[i] < arr[i - 1]){
                back = i;
                break;
            }
        }
        
        int m = (back - front) + 1;
        // reverse array from front - to - back, and check if sorted, return true
        for(int i = 0; i < m/2; i++){
            int temp = arr[i + front];
            arr[i + front] = arr[back - i];
            arr[back - i] =  temp;
        }
        
        // if not sorted, return false
        for(int i = 1; i < n; i++){
            if(arr[i - 1] > arr[i]){
                return false;
            }
        }
        
        return true;
} 
