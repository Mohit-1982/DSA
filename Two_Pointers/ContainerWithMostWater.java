Leetcode - 11
  Brute : 
    class Solution {
    public int maxArea(int[] arr) {
        int n = arr.length;
        int maxWater = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] <= arr[j]) {
                    maxWater = Math.max(maxWater, (j - i) * arr[i]);
                }else {
                    maxWater = Math.max(maxWater, (j - i) * arr[j]);
                }
            }
        }
        return maxWater;
    }
}
Optimal : 
  class Solution {
    public int maxArea(int[] arr) {
        int n = arr.length;
        int maxWater = 0;
        int l = 0;
        int r = n - 1;
        while(l < r) {
            if(arr[l] <= arr[r]) {
                maxWater = Math.max(maxWater, (r - l) * arr[l]);
                l++;
            }else {
                maxWater = Math.max(maxWater, (r - l) * arr[r]);
                r--;
            }
        }
        return maxWater;
    }
}
