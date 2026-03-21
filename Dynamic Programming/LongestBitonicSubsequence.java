GFG
  class Solution {
    public static int longestBitonicSequence(int n, int[] nums) {
        int[] LIS = new int[n];
        for(int i = 0; i < n; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) max = Math.max(max, LIS[j]);
            }
            LIS[i] = max + 1; 
        }
        int[] LDS = new int[n];
        for(int i = n - 1; i >= 0; i--) {
            int max = 0;
            for(int j = i + 1; j < n; j++) {
                if(nums[j] < nums[i]) max = Math.max(max, LDS[j]);
            }
            LDS[i] = max + 1;//here we are doing +1 that is why we have to return lis[i] + lds[i] - 1
        }
        int maxLen = 0;
        for(int i = 0; i < n; i++) {
            if(LIS[i] > 1 && LDS[i] > 1)
                maxLen = Math.max(maxLen, LIS[i] + LDS[i] - 1);
        }
        return maxLen;
    }
}
