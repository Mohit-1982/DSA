Leetcode - 70
  Brute : O(2^n)
    class Solution {
    public int climbStairs(int n) {
        if(n == 0) return 1;
        if(n < 0) return 0;
        int left = climbStairs(n - 1);
        int right = climbStairs(n - 2);
        return left + right;
    }
}
