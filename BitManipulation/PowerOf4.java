Leetcode - 342

  Approach 1 :
  class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        while(n%4 == 0) {
            n /= 4;
        }
        if(n == 1) return true;
        else return false;
    }
}

Approach 2 : 

class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        return isTwo(n) && isPerfect(n);
    }
    public boolean isTwo(int n) {
        return (n & (n-1)) == 0;
    }
    public boolean isPerfect(int n) {
        int a = (int)Math.sqrt(n);
        if(a * a == n) return true;
        else return false;
    }
}
