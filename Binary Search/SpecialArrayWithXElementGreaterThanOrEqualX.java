Leetcode - 1608
  Brute : 
    class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        int max = -1;
        for(int things : nums) max = Math.max(max, things);
        for(int i = 0; i <= max; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(nums[j] >= i) count++;
                if(count > i) break;
            }
            if(count == i) return i;
        }
        return -1;
    }
}

Optimal : 
  
