GFG
  Brute : 
    class Solution {
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        return helper(arr, 1, n - 1);
    }
    static int helper(int[] arr, int i, int j) {
        if(i >= j) return 0;
        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            int cost = arr[i - 1] * arr[k] * arr[j];
            int leftHalf = helper(arr, i, k);
            int rightHalf = helper(arr, k + 1, j);
            min = Math.min(cost + leftHalf + rightHalf, min);
        }
        return min;
    }
}
Optimal : 
  *Memoization 
    class Solution {
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(arr, 1, n - 1, dp);
    }
    static int helper(int[] arr, int i, int j, int[][] dp) {
        if(i >= j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++) {
            int cost = arr[i - 1] * arr[k] * arr[j];
            int leftHalf = helper(arr, i, k, dp);
            int rightHalf = helper(arr, k + 1, j, dp);
            min = Math.min(cost + leftHalf + rightHalf, min);
        }
        dp[i][j] = min;
        return min;
    }
}
