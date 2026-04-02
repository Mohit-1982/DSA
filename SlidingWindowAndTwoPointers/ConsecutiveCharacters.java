Leetcode - 1446
  class Solution {
    public int maxPower(String s) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int maxLen = 0;
        while(i < n) {
            j = i + 1;
            while(j < n && s.charAt(i) == s.charAt(j)) j++;
            maxLen = Math.max(maxLen, j - i);
            i = j;
        }
        return maxLen;
    }
}
