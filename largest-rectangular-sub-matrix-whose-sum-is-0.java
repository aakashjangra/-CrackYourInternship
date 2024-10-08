// Problem link - https://www.geeksforgeeks.org/problems/largest-rectangular-sub-matrix-whose-sum-is-0/1

// TC - O(N * M * M)
// SC - O(N * M)
class Solution {
    public static ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] sum = new int[n][m];

        // Precompute the prefix sum for each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum[i][j] = a[i][j] + (j > 0 ? sum[i][j - 1] : 0);
            }
        }

        int maxArea = 0, startRow = 0, endRow = -1, startCol = 0, endCol = -1;

        // Traverse all pairs of columns
        for (int c1 = 0; c1 < m; c1++) {
            for (int c2 = c1; c2 < m; c2++) {
                int[] temp = new int[n];

                // Compute the sum of elements between the two columns for each row
                for (int i = 0; i < n; i++) {
                    temp[i] = sum[i][c2] - (c1 > 0 ? sum[i][c1 - 1] : 0);
                }

                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, -1);
                int currSum = 0;

                // Find the submatrix with a sum of 0
                for (int i = 0; i < n; i++) {
                    currSum += temp[i];
                    if (map.containsKey(currSum)) {
                        int area = (c2 - c1 + 1) * (i - map.get(currSum));
                        if (area > maxArea) {
                            maxArea = area;
                            startRow = map.get(currSum) + 1;
                            endRow = i;
                            startCol = c1;
                            endCol = c2;
                        }
                    } else {
                        map.put(currSum, i);
                    }
                }
            }
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (maxArea == 0) return ans;

        // Extract the submatrix
        for (int i = startRow; i <= endRow; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = startCol; j <= endCol; j++) {
                row.add(a[i][j]);
            }
            ans.add(row);
        }

        return ans;
    }
}
