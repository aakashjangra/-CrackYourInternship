// Problem link - https://leetcode.com/problems/remove-boxes/

class Solution {
    Integer[][][] memo;
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        memo = new Integer[n][n][n];
        return helper(boxes, 0, n - 1, 0);
    }

    private int helper(int[] boxes, int i, int j, int k){
        if(i > j) return 0;
        if(memo[i][j][k] != null) return memo[i][j][k];

        int tempI = i, tempK = k;
        while(i + 1 <= j && boxes[i + 1] == boxes[i]) {
            i++;
            k++;
        }

        int res = (k + 1) * (k + 1) + helper(boxes, i + 1, j, 0);

        for(int m = i + 1; m <= j; m++){
            if(boxes[i] == boxes[m]){
                res = Math.max(res, helper(boxes, i + 1, m - 1, 0) + helper(boxes, m, j, k + 1));
            }
        }

        return memo[tempI][j][tempK] = res;
    }
}
