Leetcode - 64
  Brute : recursion
    class Solution {
    public int minPathSum(int[][] grid) {
        int[] store = new int[1];
        store[0] = Integer.MAX_VALUE;
        min(grid, 0, 0, 0, store);
        return store[0];
    }
    public void min(int[][] arr, int row, int col, int sum, int[] store) {
        if(row == arr.length - 1 && col == arr[0].length - 1) {
            sum += arr[row][col];
            store[0] = Math.min(sum, store[0]);
            return;
        }
        if(row >= arr.length || col >= arr[0].length) return;
        min(arr, row, col + 1, sum + arr[row][col], store);
        min(arr, row + 1, col, sum + arr[row][col], store);
    }
}

Optimise : 
  *Memoization
    class Solution {
    public int minPathSum(int[][] grid) {
        //Memoization
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        return minPath(0, 0, grid, dp);
    }
    public int minPath(int row, int col, int[][] arr, int[][] dp) {
        if(row >= arr.length || col >= arr[0].length) return Integer.MAX_VALUE;
        if(row == arr.length - 1 && col == arr[0].length - 1) return arr[row][col];
        if(dp[row][col] != 0) return dp[row][col];
        int right = minPath(row, col + 1, arr, dp);
        int down = minPath(row + 1, col, arr, dp);
        int ans = arr[row][col] + Math.min(right, down);
        dp[row][col] = ans;
        return ans;
    }
}
    *Tabulation
      class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) dp[i][j] = grid[i][j];
                else if(i == 0) dp[i][j] = grid[i][j] + dp[i][j - 1];
                else if(j == 0) dp[i][j] = grid[i][j] + dp[i - 1][j];
                else dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
  
