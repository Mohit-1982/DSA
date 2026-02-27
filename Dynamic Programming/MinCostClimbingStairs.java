Leetcode - 746
  Brute : 
    class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int min1 = minCost(0, cost);
        int min2 = minCost(1, cost);
        return Math.min(min1, min2);
    }
    public int minCost(int i, int[] arr) {
        if(i >= arr.length) return 0;
        int oneStep = arr[i] + minCost(i + 1, arr);
        int twoStep = arr[i] + minCost(i + 2, arr);
        int ans = Math.min(oneStep, twoStep);
        return ans;
    }
}
Optimal : Memoization
  class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        int min1 = minCost(0, cost, dp);
        int min2 = minCost(1, cost, dp);
        return Math.min(min1, min2);
    }
    public int minCost(int i, int[] arr, int[] dp) {
        if(i >= arr.length) return 0;
        if(dp[i] != -1) return dp[i];
        int oneStep = arr[i] + minCost(i + 1, arr, dp);
        int twoStep = arr[i] + minCost(i + 2, arr, dp);
        int ans = Math.min(oneStep, twoStep);
        dp[i] = ans;
        return ans;
    }
}

*Tabulation
  class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 1) return cost[0];
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
  
