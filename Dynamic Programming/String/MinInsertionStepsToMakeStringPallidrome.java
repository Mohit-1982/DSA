Leetcode - 1312
  class Solution {
    public int minInsertions(String s) {
        //do this with Tabulation and lps (Kmp)
        int n = s.length();
        int m = longestPalindromeSubseq(s);
        return n - m;
    }
    public int longestPalindromeSubseq(String s) {
        //solve this using one pointer on start and one on end
        StringBuilder str = new StringBuilder(s);
        str.reverse();
        return longestCommonSubsequence(s, str.toString());
    }
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
