Leetcode - 42
  Better : 
    class Solution {
    public int trap(int[] height) {
        int[] prefix = prefix(height);
        int[] suffix = suffix(height);
        int count = 0;
        for(int i = 0;i < height.length;i++) {
            int min = Math.min(prefix[i],suffix[i]) - height[i];
            if(min > 0) count += min;
        }
        return count;
    }
    public int[] prefix(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for(int i = 1;i<arr.length;i++) {
            prefix[i] = arr[i];
            prefix[i] = Math.max(prefix[i-1],prefix[i]);
        }
        return prefix;
    }
    public int[] suffix(int[] arr) {
        int[] suffix = new int[arr.length];
        suffix[arr.length - 1] = arr[arr.length - 1];
        for(int i = arr.length - 2;i >= 0;i--) {
            suffix[i] = arr[i];
            suffix[i] = Math.max(suffix[i+1],suffix[i]);
        }
        return suffix;
    }
}

Optimal :
  class Solution {
    public int trap(int[] arr) {
      int s = 0;
      int e = arr.length - 1;
      int res = 0;
      int leftMax = 0;
      int rightMax = 0;
      while(s < e) {
        if(arr[s] <= arr[e]) {
            if(leftMax < arr[s]) leftMax = arr[s];
            else res += leftMax - arr[s];
            s++;
        }else {
            if(rightMax < arr[e]) rightMax = arr[e];
            else res += rightMax - arr[e];
            e--;
        }
      }
      return res;
    }
}
