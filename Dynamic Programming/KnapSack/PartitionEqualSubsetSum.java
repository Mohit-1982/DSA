Leetcode - 416
  Brute : 
    class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int ele : nums) sum += ele;
        if(sum % 2 == 1) return false;
        return canWe(nums, 0, 0, 0);
    }
    public boolean canWe(int[] arr, int i, int sum1, int sum2) {
        if(i >= arr.length) {
            if(sum1 == sum2) return true;
            else return false;
        }
        boolean pickForOne = canWe(arr, i + 1, sum1 + arr[i], sum2);
        boolean pickForTwo = canWe(arr, i + 1, sum1, sum2 + arr[i]);
        return pickForOne || pickForTwo;
    }
}

Optimal : 
  *With Observation
      class Solution {
    public boolean canPartition(int[] nums) {
        //Knapsack + Memoization
        int sum = 0;
        for(int ele : nums) sum += ele;
        if(sum % 2 == 1) return false;
        int[][] dp = new int[nums.length + 1][sum / 2 + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return canWe(nums, 0, sum / 2, dp);
    }
    public boolean canWe(int[] arr, int i, int target, int[][] dp) {
        if(i >= arr.length) {
            if(target == 0) return true;
            else return false;
        }
        if(target < 0) return false;
        if(dp[i][target] != -1) return (dp[i][target] == 1);
        boolean pick = canWe(arr, i + 1, target - arr[i], dp);
        boolean skip = canWe(arr, i + 1, target, dp);
        boolean ans = (pick || skip);
        dp[i][target] = (ans) ? 1 : 0;
        return ans;
    }
}
