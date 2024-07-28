 // Problem link - https://leetcode.com/problems/next-greater-element-i/description/

// TC - O(n)
// SC - O(n)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // it maps integers to their next greater element in nums2
        HashMap<Integer, Integer> map = new HashMap<>();

        Stack<Integer> st = new Stack<>();

        for(int i = nums2.length - 1; i >= 0; i--){
            int num = nums2[i];

            while(st.size() > 0 && st.peek() <= num){
                st.pop();
            }

            if(st.size() > 0){
                map.put(num, st.peek());
            }

            st.push(num);
        }

        int[] nextGreater = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            nextGreater[i] = map.getOrDefault(nums1[i], -1);
        }

        return nextGreater;
    }
}
