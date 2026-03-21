GFG
  class Solution {
    public static int minSuperSeq(String s, String str) {
        int n = s.length();
        int m = str.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(s.charAt(i - 1) == str.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return n + m - dp[n][m];
    }
}
