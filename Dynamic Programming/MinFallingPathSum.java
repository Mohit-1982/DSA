Leetcode - 931
  Brute : 
    class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[] arr = new int[1];
        arr[0] = Integer.MAX_VALUE;
        for(int col = 0; col < matrix[0].length; col++) {
            minPath(matrix, 0, col, arr, 0);
        }
        return arr[0];
    }
    public void minPath(int[][] arr, int row, int col, int[] store, int sum) {
        if(col >= arr[0].length || col < 0) return;
        if(row == arr.length - 1) {
            sum += arr[row][col];
            store[0] = Math.min(store[0], sum);
            return;
        }
        sum += arr[row][col];
        //down
        minPath(arr, row + 1, col, store, sum);
        //diagonal right
        minPath(arr, row + 1, col + 1, store, sum);
        //diagonal left
        minPath(arr, row + 1, col - 1, store, sum);
    }
}

Optimal : 
  *Tabulation 
    class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0) dp[i][j] = matrix[i][j];
                else if(j == 0) dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                else if(j == n - 1) dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                else dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j + 1], dp[i - 1][j - 1]));
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            min = Math.min(min, dp[m - 1][i]);
        }
        return min;
    }
}
