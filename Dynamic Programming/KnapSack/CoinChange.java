Leetcode - 322
  Brute : Better to use void in this case
    class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] arr = new int[1];
        arr[0] = Integer.MAX_VALUE;
        int min = minAmount(coins, amount, 0, 0, arr);
        if(arr[0] == Integer.MAX_VALUE) return -1;
        return arr[0];
    }
    public int minAmount(int[] arr, int amount, int i, int minTaken, int[] store) {
        if(i >= arr.length) {
            if(amount == 0) {
                store[0] = Math.min(store[0], minTaken);
                return 0;
            }
            else return Integer.MIN_VALUE;
        }
        if(amount < 0) return Integer.MIN_VALUE;
        int pick = arr[i] + minAmount(arr, amount - arr[i], i, minTaken + 1, store);
        int skip = minAmount(arr, amount, i + 1, minTaken, store);
        int ans = Math.max(pick, skip);
        return ans;
    }
}

Optimal : 
  *Memoization : Knapsack
    class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int res = minAmount(coins, amount, 0, dp);
        return (res != Integer.MAX_VALUE) ? res : -1;
    }
    public int minAmount(int[] arr, int amount, int i, int[][] dp) {
        if(i >= arr.length) {
            if(amount == 0) return 0;
            else return Integer.MAX_VALUE;
        }
        if(amount < 0) return Integer.MAX_VALUE;
        if(dp[i][amount] != -1) return dp[i][amount];
        int take = minAmount(arr, amount - arr[i], i, dp);
        int pick = (take < Integer.MAX_VALUE) ? take + 1 : take;
        int skip = minAmount(arr, amount, i + 1, dp);
        int ans = Math.min(pick, skip);
        dp[i][amount] = ans;
        return ans;
    }
}
