Leetcode - 494
  Brute : 
    class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, 0, target);
    }
    public int helper(int[] arr, int i, int target) {
        if(i >= arr.length) {
            if(target == 0) return 1;//1 valid way
            else return 0;
        }
        int add = helper(arr, i + 1, target + arr[i]);
        int sub = helper(arr, i + 1, target - arr[i]);
        return add + sub;
    }
}
Optimal : 
  *Memoization
      class Solution {
    static int absSum;
    public int findTargetSumWays(int[] nums, int target) {
        absSum = 0;
        for(int ele : nums) absSum += Math.abs(ele);
        //n --> o to n - 1 and target --> -absSum to absSum  abs is absolute
        int[][] dp = new int[nums.length][2 * absSum + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(nums, 0, target, 0, dp);
    }
    public int helper(int[] arr, int i, int target, int sum, int[][] dp) {
        if(i >= arr.length) {
            if(sum == target) return 1;//1 valid way
            else return 0;
        }
        if(dp[i][sum + absSum] != -1) return dp[i][sum + absSum];
        int add = helper(arr, i + 1, target, sum + arr[i], dp);
        int sub = helper(arr, i + 1, target, sum - arr[i], dp);
        int ans = add + sub;
        dp[i][sum + absSum] = ans;
        return ans;
    }
}
