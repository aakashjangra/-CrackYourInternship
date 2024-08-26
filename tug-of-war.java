// Problem link - https://www.geeksforgeeks.org/tug-of-war/

class Solution {
    private static int solve(int[] arr, int index, int taken, int mid, int curSum, int total){
        if(index >= arr.length){
            return Integer.MAX_VALUE;
        }
        
        if(taken == mid) return curSum;
        
        int a = solve(arr, index + 1, taken, mid, curSum, total);
        int b = solve(arr, index + 1, taken + 1, mid, curSum + arr[index], total);
        
        if(Math.abs(total - a) < Math.abs(total - b)){
            return a;
        }
        
        return b;
    }
    public static ArrayList<ArrayList<Integer>> minDifference(int n, int[] arr) {
        int total = 0;
        for(int val: arr) total += val;
        int mid = (n / 2);
        int ans = solve(arr, 0, 0, mid, 0, total / 2);
        
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(Math.min(ans, total - ans));
        
        ansList.add(temp);
        
        temp = new ArrayList<>();
        temp.add(Math.max(ans, total - ans));
        
        ansList.add(temp);
        
        return ansList;
    }
}
