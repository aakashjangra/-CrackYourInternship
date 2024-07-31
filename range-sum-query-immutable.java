// Problem link - https://leetcode.com/problems/range-sum-query-immutable/

// TC - O(n) - O(n) for building and O(log n) for sumRange
// SC - O(4 * n) - size of segment array
class NumArray {
    int[] seg;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        seg = new int[4 * n];
                      
        build(0, 0, nums.length - 1, nums);
    }
    
    private void build(int index, int l, int r, int[] nums){
        if(l == r){
            seg[index] = nums[l];
            return;
        }
        
        int mid = l + (r - l)/2;
        build(index * 2 + 1, l, mid, nums);
        build(index * 2 + 2, mid + 1, r, nums);
        
        seg[index] = seg[index * 2 + 1] + seg[index * 2 + 2]; // sum of all elements in range
    }
    
    public int sumRange(int left, int right) {
        return find(0, 0, n - 1, left, right);
    }
                             
    private int find(int index, int l, int r, int left, int right){
        if(left <= l && r <= right){
            return seg[index];
        }
        
        if(right < l || left > r){
            return 0;
        }
        
        int mid = l + (r - l)/2;
        int leftSegment = find(index * 2 + 1, l, mid, left, right);
        int rightSegment = find(index * 2 + 2, mid + 1, r, left, right);
        
        return leftSegment + rightSegment;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
