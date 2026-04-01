Leetcode - 674
  class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int j = 0;
        int i = 0;
        int maxLen = 0;
        for(i = 0; i < n - 1; i++) {
            if(nums[i] >= nums[i + 1]) {
                maxLen = Math.max(maxLen, i - j + 1);
                j = i + 1;
            }
        }
        maxLen = Math.max(maxLen, i - j + 1);
        return maxLen;
    }
}
