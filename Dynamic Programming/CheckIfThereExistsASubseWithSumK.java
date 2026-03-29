GFG
  Brute : 
    class Solution {
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        return helper(arr, K, 0, 0);
    }
    public static boolean helper(int[] arr, int tar, int i, int sum) {
        if(i == arr.length) {
            if(sum == tar) return true;
            else return false;
        }
        if(sum == tar) return true;
        boolean pick = helper(arr, tar, i + 1, sum + arr[i]);
        boolean skip = helper(arr, tar, i + 1, sum);
        return pick || skip;
    }
}

Better : 
  class Solution {
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        int max = 0;
        for(int ele : arr) max += ele;
      //we can make dp size up to k no need to make till max
        Boolean[][] dp = new Boolean[arr.length][max + 1];
        return helper(arr, K, 0, 0, dp);
    }
    public static boolean helper(int[] arr, int tar, int i, int sum, Boolean[][] dp) {
        if(i == arr.length) {
            if(sum == tar) return true;
            else return false;
        }
        if(dp[i][sum] != null) return dp[i][sum];
        if(sum == tar) return true;
        boolean pick = helper(arr, tar, i + 1, sum + arr[i], dp);
        boolean skip = helper(arr, tar, i + 1, sum, dp);
        return dp[i][sum] =  (pick || skip);
    }
}
Optimal : 
  
