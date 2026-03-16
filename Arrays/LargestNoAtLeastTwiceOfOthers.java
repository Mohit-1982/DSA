Leetcode - 747
  class Solution {
    public int dominantIndex(int[] nums) {
        int max = -1;
        int maxIdx = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(i != maxIdx && max < 2 * nums[i]) {
                return -1;
            }
        }
        return maxIdx;
    }
}
