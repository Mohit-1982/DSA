Leetcode - 930

  class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int a = Sum(nums,goal);
        int b = Sum(nums,goal-1);
        int ans = a - b;
        return ans;
    }
    public int Sum(int[] arr,int k) {
        if(k < 0) return 0;
        int l = 0;
        int r = 0;
        int count = 0;
        int sum = 0;
        while(r < arr.length) {
            sum += arr[r];
            while(sum > k) {
                sum -= arr[l];
                l++;
            }
            count = count + (r-l+1);
            r++;
        }
        return count;
    }
}
