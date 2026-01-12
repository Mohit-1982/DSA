Leetcode - 875 : O(n * log(Max ele in array));
  class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //find the maximum value in array for range(end)
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<piles.length;i++) {
            max = Math.max(piles[i],max);
        }

        int s = 1;
        int e = max;
        while(s <= e) {
            int m = s + (e - s) / 2;
            long hours = minHours(m,piles);
            if(hours <= h) {
                //ans = m; if want to solve while storing ans else the low is always going to be our answer DRY RUN and seee....
                e = m - 1;
            }else { //(hours >= h) 
                s = m + 1;
            }
        }
        return s;
    }
    public long minHours(int k,int[] arr) {
        long hours = 0;
        for(int i = 0;i < arr.length; i++) {
            if(arr[i] % k == 0) hours += arr[i] / k;
            else hours += (arr[i] / k) + 1;
        }
        return hours;
    }
}
