GFG
  Brute : 
    O(n.K)
      class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int maxSum = -1;
        int n = arr.length;
        
        for (int i = 0; i <= n - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
    }
}

Optimal : 
  
