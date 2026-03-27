GFG
  class Solution {
    static int minDeletions(String s) {
        //Find the Largest subsequence then sub it from length of s
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        int[][] dp = new int[n + 1][n + 1];
        int max = -1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(s.charAt(i - 1) == sb.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return n - max;
    }
}
