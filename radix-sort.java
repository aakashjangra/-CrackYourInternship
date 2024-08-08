// Problem link - https://www.geeksforgeeks.org/problems/radix-sort/1

// TC - O(n * k), k is number of digits in maximum element
// SC - O(n + k)
class Solution
{
    static void radixSort(int arr[], int n) 
    { 
        int biggestNumber = arr[0];
        for(int val: arr){
            if(val > biggestNumber){
                biggestNumber = val;
            }
        }
        
        // sort for all places, one by one
        for(int exp = 1; biggestNumber / exp > 0; exp *= 10){
            countSort(arr, n, exp);
        }
    } 
    
    static void countSort(int[] arr, int n, int exp){
        int output[] = new int[n]; // output array
        int count[] = new int[10];
        int i;
        
        for(i = 0; i < n; i++){
            count[(arr[i] / exp) % 10]++;
        }
        
        for(i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }
        
        // iterating opposite to preserve order of same elements
        for(i = n - 1; i >= 0; i--){
            output[count[(arr[i]/exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        
        for(i = 0; i < n; i++){
            arr[i] = output[i]; 
        }
    }
}
