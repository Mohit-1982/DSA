Leetcode - 1092
  class Solution {
    public String shortestCommonSupersequence(String s, String str) {
        return minSuperSeq(s, str);
    }
    public String minSuperSeq(String s, String str) {
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
        int i = dp.length - 1;
        int j = dp[0].length - 1;
        StringBuilder nstr = new StringBuilder();
        while(i > 0 && j > 0) {
            if(s.charAt(i - 1) == str.charAt(j - 1)) {
                nstr.append(s.charAt(i - 1));
                i--;
                j--;
            }else {
                if(dp[i - 1][j] >= dp[i][j - 1]) i--;//compare left and top
                else j--;
            }
        }
        nstr.reverse();
        i = 0;
        j = 0;
        int k = 0;
        StringBuilder res = new StringBuilder();
        while(i < s.length() && j < str.length() && k < nstr.length()) {
            if(s.charAt(i) == nstr.charAt(k) && str.charAt(j) == nstr.charAt(k)) {
                res.append(s.charAt(i));
                i++;
                j++;
                k++;
            }else {
                while(i < s.length() && s.charAt(i) != nstr.charAt(k)) res.append(s.charAt(i++));
                while(j < str.length() && str.charAt(j) != nstr.charAt(k)) res.append(str.charAt(j++));
            }
        }
        while(k < nstr.length()) res.append(nstr.charAt(k++));
        while(i < s.length()) res.append(s.charAt(i++));
        while(j < str.length()) res.append(str.charAt(j++));
        return res.toString();
    }
}
