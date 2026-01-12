Leetcode - 69
  Brute : O(x) x is input number. will give TLE for x = Integer.MAX_VALUE;
    class Solution {
    public int mySqrt(int x) {
        if(x == 1) return 1;
        int ans = 0;
        for(int i = 1;i<x;i++) {
            if((long)i*i <= x) {
                ans = Math.max(i,ans);
            }else break;
        }
        return ans;
    }
}

Optimal : O(logx)
  class Solution {
    public int mySqrt(int x) {
        long s = 1;
        long e = x;
        long ans = 0;
        while(s <= e) {
            long m = (s + (e - s) / 2);
            if(m * m <= x) {
                ans = m;
                s = m + 1;
            }else { //if(m*m > x) 
                e = m - 1;
            }
        }
        return (int)ans;
    }
}
  
  
