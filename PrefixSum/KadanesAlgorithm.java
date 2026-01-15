GFG
  Brute : O(n^2)
    class Solution {
    int maxSubarraySum(int[] arr) {
        int Maxi = Integer.MIN_VALUE;
        int n = arr.length;
        for(int i = 0;i < n;i++) {
            int prefix = 0;
            for(int j = i;j < n;j++) {
                prefix += arr[j]; //calculate all the sum of subarray
                Maxi = Math.max(prefix,Maxi);
            }
        }
        return Maxi;
    }
}
//Kadanes Algorith
Optimal : O(n)
  class Solution {
    int maxSubarraySum(int[] arr) {
        int prefix = 0;
        int Maxi = Integer.MIN_VALUE;
        for(int i = 0;i < arr.length;i++) {
            prefix += arr[i];
            Maxi = Math.max(prefix,Maxi);
            if(prefix < 0) prefix = 0;
        }
        return Maxi;
    }
}
