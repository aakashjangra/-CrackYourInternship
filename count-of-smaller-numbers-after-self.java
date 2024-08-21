// Problem link - https://leetcode.com/problems/count-of-smaller-numbers-after-self/

// TC - O(N log N)
// SC - O(N)
class Solution {
    class Node{
        int val;
        int index;
        Node(int val, int index){
            this.val = val;
            this.index = index;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Node[] arr = new Node[n];
        for(int i = 0; i < n; i++){
            arr[i] = new Node(nums[i], i);
        }

        int[] ans = new int[n];
        mergeSort(0, n-1, arr, ans);

        List<Integer> ansList = new ArrayList<>();
        for(int val: ans) ansList.add(val);

        return ansList;
    }
    private void mergeSort(int l, int r, Node[] arr, int[] ans){
        if(l >= r) return;

        int mid = (l + r)/2;
        mergeSort(l, mid, arr, ans);
        mergeSort(mid + 1, r, arr, ans);

        Node[] temp = new Node[r - l + 1];
        int k = 0;
        int y = 0;
        int i = l, j = mid + 1;
        while(i <= mid && j <= r){
            if(arr[i].val <= arr[j].val){
                ans[arr[i].index] += y;
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                y++;
            }
        }

        while(i <= mid){
            ans[arr[i].index] += y;
            temp[k++] = arr[i++];
        }

        while(j <= r){
            temp[k++] = arr[j++];
        }

        for(int x = l; x <= r; x++){
            arr[x] = temp[x - l];
        }
    }
}
