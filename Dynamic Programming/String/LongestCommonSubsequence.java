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
*Tabulation : 
  
