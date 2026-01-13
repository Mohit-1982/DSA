Leetcode - 1283
  TC : O(n * log(Max In Array))

    class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for(int i = 0;i<n;i++) {
            max = Math.max(nums[i],max);
        }

        int s = 1;
        int e = max;
        int res = 0;

        while(s <= e) {
            int m = s + (e - s) / 2;
            if(divCheck(nums,m,threshold)) {
                res = m;
                e = m - 1;
            }else {
                s = m + 1;
            }
        }
        return res;
    }
    public boolean divCheck(int[] arr,int divisor,int check) {
        long ans = 0;
        for(int i = 0; i < arr.length; i++) {
            //ceil formula 
            //ans += (arr[i] + divisor - 1) / divisor
            if(ans > check) return false;
            if(arr[i] % divisor == 0) {
                ans += arr[i]/divisor;
            }else {
                ans += arr[i]/divisor + 1;
            }
        }
        if(ans <= check) return true;
        else return false;
    }
}
