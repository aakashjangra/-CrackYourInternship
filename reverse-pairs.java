// Problem link - https://leetcode.com/problems/reverse-pairs/

// TC - O(n log n)
// SC - O(n) - arr in merge function
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(0, nums.length - 1, nums);
    }

    private int mergeSort(int l, int r, int[] nums){
        if(l >= r){
            return 0;
        }

        int mid = l + (r - l)/2;
        int leftPairs = mergeSort(l, mid, nums);
        int rightPairs = mergeSort(mid + 1, r, nums);

        int pairs = leftPairs + rightPairs;

        // finding pairs
        int i = l, j = mid + 1;
        while(i <= mid && j <= r){
            if((long) nums[i] > (long) nums[j] * 2){
                pairs += mid - i + 1;
                j++;
            }
            else {
                i++;
            }
        }
 
        merge(nums, l, r);

        return pairs;
    }

    private void merge(int[] nums, int low, int high){
		int mid = low + (high - low) / 2;
		int[] arr = new int[high - low + 1];
		
		int i = low, j = mid + 1, k = 0;
		while (k < arr.length){
			int num1 = i > mid ? Integer.MAX_VALUE : nums[i];
			int num2 = j > high ? Integer.MAX_VALUE : nums[j];
			
			arr[k++] = num1 <= num2 ? nums[i++] : nums[j++];
		}
		
		for (int p = 0; p < arr.length; p++) nums[p+low] = arr[p];
	}
}
