Leetcode - 62
  Brute : Recursion
    class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1 && n == 1) return 1;
        if(m <= 0 || n <= 0) return 0;
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }
}

Optimal :
  *Memoization
    class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];//Row --> 0 to m, Col --> 0 to n
        return paths(m, n, dp);
    }
    public int paths(int m, int n, int[][] dp) {
        if(m == 1 || n == 1) return 1;
        if(dp[m][n] != 0) return dp[m][n];
        int path1 = paths(m - 1, n, dp);
        int path2 = paths(m, n - 1, dp);
        int ans = path1 + path2;
        dp[m][n] = ans;
        return ans;
    }
}

*Tabulation
  class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
