//Problem link - https://leetcode.com/problems/sort-colors/description/

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zeroIndex = 0, twoIndex = n - 1;
        //zeroIndex respresents the index where we can put a zero
        //twoIndex represents the index where we can put a two
      
        int cur = 0;

        //we are trying to put zero and two to their right place and 1 will automatically be at it's place
        while(cur <= twoIndex){
            if(nums[cur] == 0){

                if(nums[zeroIndex] == 0){
                    zeroIndex++;
                    cur++;
                } else {
                    int temp = nums[zeroIndex];
                    nums[zeroIndex] = nums[cur];
                    nums[cur] = temp;
                    zeroIndex++;
                }

                
            } else if(nums[cur] == 2){

                if(nums[twoIndex] == 2){
                    twoIndex--;
                } else {
                    int temp = nums[twoIndex];
                    nums[twoIndex] = nums[cur];
                    nums[cur] = temp;
                    twoIndex--;
                }
                
            } else {
              //if value is 1, skip this index
                cur++;
            }
        }
    }
}
