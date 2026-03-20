Leetcode - 1143
  Brute : 
    class Solution {
    public int longestCommonSubsequence(String s, String str) {
        return helper(s, str, s.length() - 1, str.length() - 1);
    }
    public int helper(String s, String str, int i, int j) {
        if(i < 0 || j < 0) {
            return 0;
        }
        if(s.charAt(i) == str.charAt(j)) {
            return 1 + helper(s, str, i - 1, j - 1);
        }else {
            int firstLenMinOne = helper(s, str, i - 1, j);
            int secondLenMinOne = helper(s, str, i, j - 1);
            return Math.max(firstLenMinOne, secondLenMinOne);
        }
    }
}

Optimal : 
  *Memoization : 
    class Solution {
    public int longestCommonSubsequence(String s, String str) {
        int n = s.length();
        int m = str.length();
        //i --> n - 1 to 0 and j --> m - 1 to 0
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helper(new StringBuilder(s), new StringBuilder(str), n - 1, m - 1, dp);
    }
    public int helper(StringBuilder s, StringBuilder str, int i, int j, int[][] dp) {
        if(i < 0 || j < 0) {
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        if(s.charAt(i) == str.charAt(j)) {
            ans = 1 + helper(s, str, i - 1, j - 1, dp);
        }else {
            int firstLenMinOne = helper(s, str, i - 1, j, dp);
            int secondLenMinOne = helper(s, str, i, j - 1, dp);
            ans = Math.max(firstLenMinOne, secondLenMinOne);
        }
        dp[i][j] = ans;
        return ans;
    }
}
*Memoization : 
  class Solution {
    static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helper(new StringBuilder(s1), new StringBuilder(s2), n - 1, m - 1, dp);
    }
    static int helper(StringBuilder s, StringBuilder str, int i, int j, int[][] dp) {
        if(i == -1 || j == -1) {
            //When either one of string ends means we dont have any lcs left
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == str.charAt(j)) {
            int res = 1 + helper(s, str, i - 1, j - 1, dp);
            dp[i][j] = res;
            return res;
        }else {
            //Return Which gives More Longest Subsequence
            int res1 = Math.max(helper(s, str, i - 1, j, dp), helper(s, str, i, j - 1, dp));
            dp[i][j] = res1;
            return res1;
        }
    }
*Tabulation : 
    class Solution {
    static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = (i != 0 && j != 0) ? 1 + dp[i - 1][j - 1] : 1;
                else {
                    int pick1 = (i != 0) ? dp[i - 1][j] : 0;
                    int pick2 = (j != 0) ? dp[i][j - 1] : 0;
                    dp[i][j] = Math.max(pick1, pick2);
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}

*Tabulation More Good : 
    class Solution {
    static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1; i <= dp.length - 1; i++) {
            for(int j = 1; j <= dp[0].length - 1; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
  
