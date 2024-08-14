// Problem link - https://www.geeksforgeeks.org/problems/find-pair-given-difference1559/1

// TC - O(n)
// SC - O(n)
class Solution {
    public int findPair(int n, int x, int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int val: arr){
            if(set.contains(val - x) || set.contains(val + x)){
                return 1; //pair found
            }
            set.add(val);
        }
        
        return -1;
    }
}
