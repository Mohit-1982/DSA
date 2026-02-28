GFG
  Brute : Recursion TC : O(2^n)
    class Solution {
    public int findMaxSum(int arr[]) {
        int[] store = new int[1];
        store[0] = Integer.MIN_VALUE;
            max(0, arr, 0, store);
        return store[0];
    }
    public void max(int i, int[] arr, int sum, int[] store) {
        if(i >= arr.length) {
            store[0] = Math.max(store[0], sum);
            return;
        }
        max(i + 2, arr,  sum + arr[i], store);
        max(i + 1, arr, sum, store);
    }
}
More Readable : 
  class Solution {
    public int findMaxSum(int arr[]) {
        return max(0, arr);
    }
    public int max(int i, int[] arr) {
        if(i >= arr.length) return 0;
        int pick = arr[i] + max(i + 2, arr);
        int skip = max(i + 1, arr);
        return Math.max(pick, skip);
    }
}

Optimal : 
  *Memoization
  class Solution {
    public int findMaxSum(int arr[]) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return max(0, arr, dp);
    }
    public int max(int i, int[] arr, int[] dp) {
        if(i >= arr.length) return 0;
        if(dp[i] != -1) return dp[i];
        int pick = arr[i] + max(i + 2, arr, dp);
        int skip = max(i + 1, arr, dp);
        int ans = Math.max(pick, skip);
        dp[i] = ans;
        return ans;
    }
}

*Tabulation
    class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if(nums.length > 1) dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}

*Space Optimization
  class Solution {
    public int findMaxSum(int arr[]) {
        if(arr.length == 1) return arr[0];
        if(arr.length == 2) return Math.max(arr[0], arr[1]);
        int[] dp = new int[3];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for(int i = 2; i < arr.length; i++) {
            dp[2] = Math.max(dp[1], arr[i] + dp[0]);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }
}
