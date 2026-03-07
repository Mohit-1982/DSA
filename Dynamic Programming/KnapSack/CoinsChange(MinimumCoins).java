GFG
  Brute : 
    class Solution {
    public int minCoins(int coins[], int sum) {
        //unbound knapsack
        int ans = helper(coins, sum, 0);
        return (ans != Integer.MAX_VALUE) ? ans : -1;
    }
    public int helper(int[] coins, int sum, int i) {
        if(i >= coins.length) {
            if(sum == 0) return 0;
            else return Integer.MAX_VALUE;
        }
        if(sum < 0) return Integer.MAX_VALUE;
        int take = helper(coins, sum - coins[i], i);
        int pick = (take < Integer.MAX_VALUE) ? take + 1 : take;
        int skip = helper(coins, sum, i + 1);
        int ans = Math.min(pick, skip);
        return ans;
    }
}
Optimal : 
  *Memoization : 
    class Solution {
    public int minCoins(int coins[], int sum) {
        //unbound knapsack
        //i --> 0 to n - 1 and sum --> sum to 0
        int[][] dp = new int[coins.length][sum + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = helper(coins, sum, 0, dp);
        return (ans != Integer.MAX_VALUE) ? ans : -1;
    }
    public int helper(int[] coins, int sum, int i, int[][] dp) {
        if(i >= coins.length) {
            if(sum == 0) return 0;
            else return Integer.MAX_VALUE;
        }
        if(sum < 0) return Integer.MAX_VALUE;
        if(dp[i][sum] != -1) return dp[i][sum];
        int take = helper(coins, sum - coins[i], i, dp);
        int pick = (take < Integer.MAX_VALUE) ? take + 1 : take;
        int skip = helper(coins, sum, i + 1, dp);
        int ans = Math.min(pick, skip);
        dp[i][sum] = ans;
        return ans;
    }
}
