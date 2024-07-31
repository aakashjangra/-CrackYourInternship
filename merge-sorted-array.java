// Problem link - https://leetcode.com/problems/merge-sorted-array/description/

// TC - O(m + n)
// SC - O(1)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m - 1, ptr2 = n - 1;

        int placeAt = m + n - 1;

        while(ptr1 >= 0 && ptr2 >= 0){
            if(nums1[ptr1] > nums2[ptr2]){
                nums1[placeAt] = nums1[ptr1];
                ptr1--;
            } else {
                nums1[placeAt] = nums2[ptr2];
                ptr2--;
            }

            placeAt--;
        }

        while(ptr1 >= 0){
            nums1[placeAt] = nums1[ptr1];
            ptr1--;
            placeAt--;
        }

        while(ptr2 >= 0){
            nums1[placeAt] = nums2[ptr2];
            ptr2--;
            placeAt--;
        }
    }
}
