Leetcode - 239

  //Brute force approach : 
class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[n-k+1];
        for(int i = 0;i<n-k+1;i++){
            int max = Integer.MIN_VALUE;
            for(int j = i;j<k+i;j++){
                if(arr[j] > max) max = arr[j];
            }
            ans[i] = max;
        }
        return ans;
    }
}
