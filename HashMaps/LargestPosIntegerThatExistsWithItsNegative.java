Leetcode - 2441
  class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele : nums) set.add(ele);
        int max = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max && set.contains(-1 * nums[i])) {
                max = Math.abs(nums[i]);
            }
        }
        return (max > 0) ? max : -1;
    }
}
