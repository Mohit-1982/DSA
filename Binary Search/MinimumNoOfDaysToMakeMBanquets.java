Leetcode - 1482

TC -- O(n * log(MAX in Array - MIN in Array + 1))
  class Solution {
    public int minDays(int[] bloomDay, int boke, int k) {
        int n = bloomDay.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        if((long) boke * k > n) return -1; //impossible case 

        for(int i = 0;i<n;i++) {
            min = Math.min(bloomDay[i],min);
            max = Math.max(bloomDay[i],max);
        }

        int s = min;
        int e = max;
        int res = 0;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(bloom(m,k,bloomDay,boke)) {
                res = m;
                e = m - 1;
            }else {
                s = m + 1;
            }
        }
        return res;
    }
    public boolean bloom(int m,int k,int[] arr,int boke) {
            int n = arr.length;
            int count = 0;
            int ans = 0;
            for(int i = 0;i<n;i++) {
              if(arr[i] <= m) count++;
              if(arr[i] > m) {
                ans += count/k;
                count = 0;
              }  
        }
        ans += count/k;
        if(ans >= boke) return true;
        else return false;
    }
}
