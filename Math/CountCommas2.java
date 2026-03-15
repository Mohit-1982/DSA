Contest
  Brute : 
  class Solution {
    public long countCommas(long n) {
        long commaCount = 0;
        if(n < 1000) return 0;
        if(n < 1000000) return n - 999;
        commaCount = 999999 - 999;
        for(int i = 1000000; i <= n; i++) {
            // int digits = getDigit(i);
            int digits = (int)Math.log10(i) + 1;
            if(digits % 3 == 0) {
                commaCount += (digits / 3) - 1;
            }else {
                commaCount += (digits / 3);
            }
        }
        return commaCount;
    }
    public int getDigit(int n) {
        int digit = 0;
        while(n != 0) {
            digit++;
            n /= 10;
        }
        return digit;
    }
}©leetcode

    Optimal : 
      
