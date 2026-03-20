Leetcode - 72
  Brute : 
    class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        StringBuilder s = new StringBuilder(word1);
        StringBuilder str = new StringBuilder(word2);
        return helper(s, str, n - 1, m - 1);
    }
    public int helper(StringBuilder s, StringBuilder str, int i, int j) {
        if(i < 0) return j + 1;//insert remaning characters of s2
        if(j < 0) return i + 1;//removing extra characters of s1
        if(s.charAt(i) == str.charAt(j)) {
            return helper(s, str, i - 1, j - 1);
        }else {
            int replace = 1 + helper(s, str, i - 1, j - 1);
            int remove = 1 + helper(s, str, i - 1, j);
            int insert = 1 + helper(s, str, i, j - 1);
            return Math.min(replace, Math.min(remove, insert));
        }
    }
}
Optimal : 
*Memoization : 
  class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        StringBuilder s = new StringBuilder(word1);
        StringBuilder str = new StringBuilder(word2);
        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helper(s, str, n - 1, m - 1, dp);
    }
    public int helper(StringBuilder s, StringBuilder str, int i, int j, int[][] dp) {
        if(i < 0) return j + 1;//insert remaning characters of s2
        if(j < 0) return i + 1;//removing extra characters of s1
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        if(s.charAt(i) == str.charAt(j)) {
            ans = helper(s, str, i - 1, j - 1, dp);
        }else {
            int replace = 1 + helper(s, str, i - 1, j - 1, dp);
            int remove = 1 + helper(s, str, i - 1, j, dp);
            int insert = 1 + helper(s, str, i, j - 1, dp);
            ans = Math.min(replace, Math.min(remove, insert));
        }
        dp[i][j] = ans;
        return ans;
    }
}

*Tabulation : 
  class Solution {
    public int editDistance(String s, String str) {
        int n = s.length();
        int m = str.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for(int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(s.charAt(i - 1) == str.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    int insert = 1 + dp[i][j - 1];
                    int replace = 1 + dp[i - 1][j - 1];
                    int remove = 1 + dp[i - 1][j];
                    dp[i][j] = Math.min(insert, Math.min(replace, remove));
                }
            }
        }
        return dp[n][m];
    }
}
