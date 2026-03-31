Leetcode - 962
  Brute : 
    class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int maxWidth = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] <= nums[j]) {
                    maxWidth = Math.max(maxWidth, j - i);
                }
            }
        }
        return maxWidth;
    }
}
Slightly Better :
  class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int maxWidth = 0;
        for(int i = 0; i < n; i++) {
            for(int j = n - 1; j > i; j--) {
                if(nums[i] <= nums[j]) {
                  //we are starting from last index if we found a answer then we can break as we wont get any better result then that one even if we check on left side so just break it
                    maxWidth = Math.max(maxWidth, j - i);
                    break;
                }
            }
        }
        return maxWidth;
    }
}
Optimal : 
  class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int maxWidth = 0;
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }
        int j = 0;
        for(int i = 0; i < n; i++) {
            while(j < n && nums[i] <= rightMax[j]) {
                maxWidth = Math.max(maxWidth, j - i);
                j++;
            }
            if(j >= n) break;
        }
        return maxWidth;
    }
}
  
