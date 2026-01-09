Leetcode - 1004

Time comp O(n)

class Solution {
    public int longestOnes(int[] nums, int k) {
        int zero = 0;
        int l = 0;
        int r = 0;
        int len = 0;
        int maxLen = 0;
        while(r < nums.length) {
            if(nums[r] == 0) zero++;
            if(zero <= k) {
                len = r-l+1;
                maxLen = Math.max(len,maxLen);
            }else if(zero > k) {
                if(nums[l] == 0) zero--; 
                l++;
            }
            r++;
        }
        return maxLen;
    }
}
