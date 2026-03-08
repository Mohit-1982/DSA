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
