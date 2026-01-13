GFG    TC : O(n * log(sum-max))

  class Solution {
    public int minTime(int[] arr, int k) {
        int sum = 0;
        int max = -1;
        for(int i = 0;i<arr.length;i++) {
            sum += arr[i];
            max = Math.max(arr[i],max);
        }
        int s = max;
        int e = sum;
        int res = -1;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(timeTaken(m,arr,k)) {
                res = m;
                e = m -1;
            }else {
                s = m + 1;
        }
    }
    return res;
    }
    public boolean timeTaken(int time,int[] arr,int painters) {
        int ans = 1;
        int capacity = 0;
        for(int i = 0;i<arr.length;i++) {
            if(arr[i] + capacity > time) {
                ans++;
                capacity = arr[i];
                if(ans > painters) return false;
            }else {
                capacity += arr[i];
            }
        }
        return true;
    }
}
