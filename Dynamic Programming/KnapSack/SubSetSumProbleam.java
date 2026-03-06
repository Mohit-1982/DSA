GFG
  class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        //KnapSack
        //idx --> 0 to n - 1
        //sum --> sum to 0
        Boolean[][] dp = new Boolean[arr.length][sum + 1];
        return helper(arr, sum, 0, dp);
    }
    static boolean helper(int[] arr, int sum, int i, Boolean[][] dp) {
        if(i >= arr.length) {
            if(sum == 0) return true;
            else return false;
        }
        if(sum == 0) return true;
        if(sum < 0) return false;
        if(dp[i][sum] != null) return dp[i][sum];
        boolean pick = helper(arr, sum - arr[i], i + 1, dp);
        boolean skip = helper(arr, sum, i + 1, dp);
        boolean ans = (pick || skip);
        dp[i][sum] = ans;
        return ans;
    }
}
