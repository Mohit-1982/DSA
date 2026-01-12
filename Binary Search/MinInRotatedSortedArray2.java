Leetcode - 154

  class Solution {
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while(s <= e) {
            int m = s + (e - s) / 2;
            min = Math.min(min,nums[m]);
            if(nums[m] == nums[s] && nums[m] == nums[e]) {
                s = s + 1;
                e = e - 1;
            }
            else if(nums[m] > nums[e]) {
                s = m + 1;
            }else {
                e = m - 1;
            }
        }
        return min;
    }
}
