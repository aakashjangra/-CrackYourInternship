// https://www.geeksforgeeks.org/problems/smallest-positive-missing-number-1587115621/1

// TC - O(n)
// SC - O(1)
class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        int posIndex = 0;
        
        for(int i = 0; i < size; i++){
            if(arr[i] > 0){
                arr[posIndex] = arr[i];
                posIndex++;
            }   
        }
        
        for(int i = 0; i < posIndex; i++){
            int index = Math.abs(arr[i]);
            
            if(index > 0 && index <= size && arr[index - 1] > 0){
                arr[index - 1] = -arr[index - 1];   
            }
        }
        
        for(int i = 0; i <= posIndex; i++){
            if(arr[i] > 0) return i + 1;
        }
        
        return posIndex + 1;
    }
}
