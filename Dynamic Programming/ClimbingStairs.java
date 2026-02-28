Leetcode - 70
  *Memoization
  class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climb(n, dp);
    }
    public int climb(int i, int[] dp) {
        if(i == 1 || i == 2) return i;
        if(dp[i] != -1) return dp[i];
        int one = climb(i - 1, dp);
        int two = climb(i - 2, dp);
        int ans = one + two;
        dp[i] = ans;
        return ans;
    }
}

*Tabulation
    class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if(n >= 1) dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
