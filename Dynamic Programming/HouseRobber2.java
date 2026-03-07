Leetcode - 213
  *Brute : 
      class Solution {
    public int rob(int[] nums) {
        return helper(nums, 0, false);
    }
    public int helper(int[] arr, int i, boolean firstTaken) {
        if(i >= arr.length) return 0;
        if(firstTaken && i == arr.length - 1) return 0;
        int pick = -1;
        int skip = -1;
        if(i == 0) {
            pick = arr[i] + helper(arr, i + 2, true);
            skip = helper(arr, i + 1, false);
        }else {
            pick = arr[i] + helper(arr, i + 2, firstTaken);
            skip = helper(arr, i + 1, firstTaken);
        }
        return Math.max(pick, skip);
    }
}
Optimal : 
  *Memoization : 
    
