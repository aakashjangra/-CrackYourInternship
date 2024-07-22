// Problem Link - https://www.geeksforgeeks.org/problems/product-array-puzzle4525/1

// without using / (division) operator
// TC - O(n)
// SC - O(n)
class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
	{ 
        long totalProduct = 1;
        
        long[] preProduct = new long[n];
        long[] postProduct = new long[n];
        Arrays.fill(preProduct, 1);
        Arrays.fill(postProduct, 1);
        
        for(int i = 1; i < n; i++){
            preProduct[i] = preProduct[i - 1] * nums[i - 1];
            postProduct[n - i - 1] = postProduct[n - i] * nums[n - i];
        }
        
        long[] ans = new long[n];
        
        for(int i = 0; i < n; i++){
            ans[i] = preProduct[i] * postProduct[i];
        }
        
        return ans;
	} 
} 
