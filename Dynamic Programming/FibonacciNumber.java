Leetcode - 509
  Brute : recursion
    TC : O(2 ^ n)
    class Solution {
    public int fib(int n) {
        if(n == 0 || n == 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
}

Optimal : DP 
  *Memoization
  class Solution {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        return fibo(n, dp);
    }
    public int fibo(int n, int[] dp) {
        if(n <= 1) return n;
        if(dp[n] != 0) return dp[n];
        int ans = fibo(n - 1, dp) + fibo(n - 2, dp);
        dp[n] = ans;
        return ans;
    }
}

*Tabulation
  class Solution {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        if(n >= 1) dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
*Space Optimization
  class Solution {
    public int fib(int n) {
        if(n <= 1) return n;
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[2] = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }
}
*Without Array
  class Solution {
    public int fib(int n) {
       if(n <= 1) return n;
        int a = 0;
        int b = 1;
        int c = 0;
        for(int i = 2; i <=n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c; 
    }
}
