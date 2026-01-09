Leetcode - 1423
Time Complexity -- > O(K)
  
  class Solution {
    public int maxScore(int[] arr, int k) {
        if(k == arr.length) {
            int sum = 0;
            for(int ele : arr) sum += ele;
            return sum;
        }
        int i = 0;
        int j = arr.length - 1;
        int lsum = 0;
        int rsum = 0;
        int MaxSum = 0;
        for(i = 0;i<k;i++) {
            lsum += arr[i];
        }
        i--;
        MaxSum = lsum + rsum;
        while(i != -1) {
            lsum -= arr[i];
            rsum += arr[j];
            i--;
            j--;
            MaxSum = Math.max(MaxSum,(lsum + rsum));
        }
        return MaxSum;
    }
}
