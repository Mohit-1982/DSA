GFG
  class Solution {
    public List<String> allLCS(String s, String str) {
        // 1. Find the Lcs using tabulation
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
        HashSet<String> res = new HashSet<>();
        //To generate all the strings we have to use recursion
        helper(res, dp, dp.length - 1, dp[0].length - 1, new StringBuilder(), s, str);
        List<String> list = new ArrayList<>(res);
        Collections.sort(list);
        return list;
    }
    public void helper(HashSet<String> res, int[][] dp, int row, int col, StringBuilder p, String s, String str) {
        if(row == 0 || col == 0) {
            p.reverse();
            res.add(p.toString());
            p.reverse();
            return;
        }
        if(s.charAt(row - 1) == str.charAt(col - 1)) {
            //Same ha tho diagonally jayege
            p.append(s.charAt(row - 1));
            helper(res, dp, row - 1, col - 1, p, s, str);
            p.deleteCharAt(p.length() - 1);
        }else {
            //agar same nhi h tho doo case banege either upar jao yah left
            if(dp[row - 1][col] == dp[row][col]) helper(res, dp, row - 1, col, p, s, str);
            if(dp[row][col - 1] == dp[row][col]) helper(res, dp, row, col - 1, p, s, str);
        }
    }
}
