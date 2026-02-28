Leetcode - 63
  Brute : Recursion
    class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        return paths(arr, 0, 0);
    }
    public int paths(int[][] arr, int row, int col) {
        if(row == arr.length - 1 && col == arr[0].length - 1 && arr[row][col] != 1) return 1;
        if(row >= arr.length || col >= arr[0].length || arr[row][col] == 1) return 0;
        return paths(arr, row + 1, col) + paths(arr, row, col + 1);
    }
}
Optimal : 
  *Memoization
    class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return paths(arr, 0, 0, dp);
    }
    public int paths(int[][] arr, int row, int col, int[][] dp) {
        if(row == arr.length - 1 && col == arr[0].length - 1 && arr[row][col] != 1) return 1;
        if(row >= arr.length || col >= arr[0].length || arr[row][col] == 1) return 0;
        if(dp[row][col] != -1) return dp[row][col];
        int down = paths(arr, row + 1, col, dp);
        int right = paths(arr, row, col + 1, dp);
        int ans = down + right;
        dp[row][col] = ans;
        return ans;
    }
}

*Tabulation
  
