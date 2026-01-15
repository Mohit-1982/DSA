Leetcode - 50
  class Solution {
    public double myPow(double x, int n) {
        long neg = 0;
        long N = n;
        if(N < 0) {
            neg = 1;
            N *= -1;//it can cause overflow error for Integer.MIN_VALUE That is why we initialise a new variable N which stores value of n.....
        }
        double ans = power(x,N);
        if(neg == 1) return 1 / ans;
        else return ans;
    }
    public double power(double x,long n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        double power = power(x,n/2);
        if(n % 2 == 0) {
            return power * power;
        }else {
            return power * power * x;
        }
    }
}
