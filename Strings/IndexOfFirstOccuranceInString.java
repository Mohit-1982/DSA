Leetcode - 28
  Brute : O(n*m)
    class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if(n < m) return -1;
        if(n == m) {
            if(haystack.equals(needle)) return 0;
            else return -1;
        }
        for(int i = 0;i <= n - m; i++) {
            int first = i;
            int second = 0;
            while(second < m) {
                if(haystack.charAt(first) == needle.charAt(second)) {
                    first++;
                    second++;
                }else {
                    break;
                }
            }
            if(second == m) {
                return first - second;
            }
        }
        return -1;
    }
}

Optimal : TC O(n + m)   SC : o(m)
    
