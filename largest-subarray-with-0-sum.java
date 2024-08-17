// Problem link - https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

// TC - O(N log N) - (log N for the search operation of map)
// SC - O(N)
class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer, Integer> sumIndex = new HashMap<>();
        
        sumIndex.put(0, -1);
        
        int largestLen = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            
            if(sumIndex.containsKey(sum)){
                largestLen = Math.max(largestLen, i - sumIndex.get(sum));
            } else {
                // first index where sum is found, bcz we want largest LEN
                sumIndex.put(sum, i);
            }
        }
        
        return largestLen;
    }
}
