Leetcode - 300
  Brute : 
    class Solution {
    public int lengthOfLIS(int[] nums) {
        return helper(nums, 0, -1);
    }
    public int helper(int[] nums, int idx, int prevIdx) {
        if(idx == nums.length) return 0;
        int pick = -1;
        if(prevIdx == -1 || nums[idx] > nums[prevIdx]) {
            pick =  1 + helper(nums, idx + 1, idx);
        }
        int skip = helper(nums, idx + 1, prevIdx);
        return Math.max(pick, skip);
    }
}

Better : *Memoization 
    class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helper(nums, 0, -1, dp);
    }
    public int helper(int[] nums, int idx, int prevIdx, int[][] dp) {
        if(idx == nums.length) return 0;
        if(dp[idx][prevIdx + 1] != -1) return dp[idx][prevIdx + 1];
        int pick = 0;
        if(prevIdx == -1 || nums[idx] > nums[prevIdx]) {
            pick =  1 + helper(nums, idx + 1, idx, dp);
        }
        int skip = helper(nums, idx + 1, prevIdx, dp);
        int ans = Math.max(pick, skip);
        dp[idx][prevIdx + 1] = ans;
        return ans;
    }
}
*Tabulation 
  class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            int max = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(nums[j] < nums[i]) max = Math.max(max, dp[j]);
            }
            dp[i] = max + 1;
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }
}

*Optimal : 
  Binary Search : 
      class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(res.isEmpty() || res.get(res.size() -1) < nums[i]) res.add(nums[i]);
            else {
                int s = 0;
                int e = res.size() - 1;
                int lowerBound = -1;
                while(s <= e) {
                    int m = s + (e - s) / 2;
                    if(res.get(m) >= nums[i]) {
                        lowerBound = m;
                        e = m - 1;
                    }else {
                        s = m + 1;
                    }
                }
                res.set(lowerBound, nums[i]);
            }
        }
        return res.size();
    }
}
