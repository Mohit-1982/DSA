GFG
  class Solution {
    public int count(int coins[], int sum) {
        //we just have to return total number of ways 
        //the solution we have usen is for finding the minCoins
        //so we just changes some things mainly instead of Min(pick, skip)
        // we return pick + skip and in base case we return 1 and 0
        //as a valid ans and invalid ans
        return minCoins(coins, sum);
    }
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
            if(sum == 0) return 1;
            else return 0;
        }
        if(sum < 0) return 0;
        if(dp[i][sum] != -1) return dp[i][sum];
        int pick = helper(coins, sum - coins[i], i, dp);
        int skip = helper(coins, sum, i + 1, dp);
        int ans = pick + skip;
        dp[i][sum] = ans;
        return ans;
    }
}
