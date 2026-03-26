GFG
  Brute : 
    class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        return helper(price, 0, n);
    }
    public int helper(int[] price, int i, int capacity) {
        if(i >= price.length || capacity == 0) return 0;
        int pick = 0;
        if(capacity >= i + 1) pick = price[i] + helper(price, i, capacity - (i + 1));
        int skip = helper(price, i + 1, capacity);
        return Math.max(pick, skip);
    }
}
Better : 
  *Memoization 
    class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        //i --> 0 to n - 1 and n --> n to 0
        int[][] dp = new int[n][n + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(price, 0, n, dp);
    }
    public int helper(int[] price, int i, int capacity, int[][] dp) {
        if(i >= price.length || capacity == 0) return 0;
        if(dp[i][capacity] != -1) return dp[i][capacity];
        int pick = 0;
        if(capacity >= i + 1) pick = price[i] + helper(price, i, capacity - (i + 1), dp);
        int skip = helper(price, i + 1, capacity, dp);
        return dp[i][capacity] = Math.max(pick, skip);
    }
}
  *Tabulation 
    class Solution {
    public int cutRod(int[] price) {
        int n = price.length;
        int[][] dp = new int[n][n + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                int take = 0;
                int notTake = 0;
                if(j >= i + 1) {
                    take = price[i] + dp[i][j - (i + 1)];
                }
                if(i > 0) {
                    notTake = dp[i - 1][j];
                }
                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
