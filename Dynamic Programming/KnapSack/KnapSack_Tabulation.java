GFG
  class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        int[][] dp = new int[val.length + 1][W + 1];
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(wt[i - 1] <= j) dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[dp.length - 1][W];
    }
}
