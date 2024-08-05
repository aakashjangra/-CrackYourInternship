// Problem link - https://www.geeksforgeeks.org/problems/minimum-swaps/1

// TC - O(n log n)
// SC - O(n)
class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        int count = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(nums[i], i);
        }
        
        Arrays.sort(nums);
        for(int i = 0; i < n; i++){
            // if not equal to previous index
            if(i != map.get(nums[i])){
                swap(nums, i, map.get(nums[i]));
                i--; // we need to check this index again
                count++;
            }
        }
        
        return count;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
