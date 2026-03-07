Leetcode - 279
  Brute : 
    class Solution {
    public int numSquares(int n) {
        //unbound knapsack
        int sqrt = (int) Math.sqrt(n);
        int[] arr = new int[sqrt + 1];
        for(int i = 1; i < arr.length; i++) {
            arr[i] = i * i;
        }
        return helper(arr, 1, n, 0);
    }
    public int helper(int[] arr, int i, int num, int count) {
        if(i >= arr.length) {
            if(num == 0) return count;
            else return Integer.MAX_VALUE;
        }
        if(num < 0) return Integer.MAX_VALUE;
        int pick = helper(arr, i, num - arr[i], count + 1);
        int skip = helper(arr, i + 1, num, count);
        int ans = Math.min(pick, skip);
        return ans;
    }
}

Optimal : 
  *Memoization : 
    class Solution {
    public int numSquares(int n) {
        //unbound knapsack
        int sqrt = (int) Math.sqrt(n);
        int[] arr = new int[sqrt + 1];
        int[][] dp = new int[arr.length][n + 1];
        for(int i = 1; i < arr.length; i++) {
            arr[i] = i * i;
        }
        for(int i = 0; i < dp.length; i++) 
            for(int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;

        return helper(arr, 1, n, dp);
    }
    public int helper(int[] arr, int i, int num, int[][] dp) {
        if(i >= arr.length) {
            if(num == 0) return 0;
            else return Integer.MAX_VALUE;
        }
        if(num < 0) return Integer.MAX_VALUE;
        if(dp[i][num] != -1) return dp[i][num];
        int take = helper(arr, i, num - arr[i], dp);
        int pick = (take < Integer.MAX_VALUE) ? take + 1 : take;
        int skip = helper(arr, i + 1, num, dp);
        int ans = Math.min(pick, skip);
        dp[i][num] = ans;
        return ans;
    }
}
