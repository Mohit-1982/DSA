Leetcode - 1011
  TC : O(n * log(sum-max+1))
    class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i<n;i++) {
            max = Math.max(max,weights[i]);
            sum += weights[i];
        }
        int s = max;
        int e = sum;
        int res = -1;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(capacityCheck(m,weights,days)) {
                res = m;
                e = m - 1;
            }else {
                s = m + 1;
            }
        }
        return res;
    }
    public boolean capacityCheck(int capacity,int[] arr,int check) {
        int sum = 0;
        int days = 1;//day always start with 1 not 0
        for(int i = 0;i<arr.length;i++) {
            if(sum + arr[i] > capacity) {
                sum = arr[i]; //it will start the next loop with that package otherwise it will not be taken in sum 
                days++; 
            }else {
                sum += arr[i];
            }
        }
        if(days <= check) return true;
        else return false;
    }
}
