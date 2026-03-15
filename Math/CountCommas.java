COntest
  class Solution {
    public int countCommas(int n) {
        if(n < 1000) return 0;
        // int count = 0; Brute Force
        // for(int i = 1000; i <= n; i++) {
        //     count++;
        // }
        // return count;
        return n - 999;
    }
}©leetcode
