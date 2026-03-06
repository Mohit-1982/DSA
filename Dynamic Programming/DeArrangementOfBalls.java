GFG
  Recursion
  class Solution {
    static int countDer(int n) {
        if(n == 1) return 0;
        if(n == 2) return 1;
        return (n - 1) * (countDer(n - 2) + countDer(n - 1));
    }
}

DP : 
  *Memoization
    class Solution {
    static int countDer(int n) {
        int[] dp = new int[n + 1];
        return count(n, dp);
    }
    static int count(int n, int[] dp) {
        if(n == 1) return 0;
        if(n == 2) return 1;
        if(dp[n] != 0) return dp[n];
        int noSwap = count(n - 1, dp);
        int swapTwo = count(n - 2, dp);
        int ans = (n - 1) * (noSwap + swapTwo);
        dp[n] = ans;
        return ans;
    }
}
*Tabulation
  class Solution {
    static int countDer(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        if(n > 1) dp[2] = 1;
        for(int i = 3; i <= n; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]);
        }
        return dp[n];
    }
}

*Space Optimization
    class Solution {
    static int countDer(int n) {
        if(n == 1) return 0;
        if(n == 2) return 1;
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 3; i <= n; i++) {
            dp[2] = (i - 1) * (dp[0] + dp[1]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }
}
    
