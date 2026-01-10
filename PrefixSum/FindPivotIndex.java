Leetcode - 724
    
Optimal Approach :
    
    class Solution {
    public int pivotIndex(int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        for(int i = 0;i<nums.length;i++) {
            sum += nums[i];
        }
        for(int i = 0;i<nums.length;i++) {
            right = sum - left - nums[i];
            if(left == right) return i;
            left += nums[i];
        }
        return -1;
    }
}

Brute Approach :
    
class Solution {
    public int pivotIndex(int[] nums) {
        int[] a = prefixSum(nums);
        int[] b = sufixSum(nums);
        for(int i = 0;i<nums.length;i++) {
            if(a[i] == b[i]) return i;
        }
        return -1;
    }
    public int[] prefixSum(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = 0;
        for(int i = 1;i<n;i++) {
            prefix[i] = prefix[i-1] + arr[i-1];
        }
        return prefix;
    }
    public int[] sufixSum(int[] arr) {
        int n = arr.length;
        int[] suffix = new int[n];
        suffix[n-1] = 0;
        for(int i = n-2;i>=0;i--) {
            suffix[i] = suffix[i+1] + arr[i+1];
        }
        return suffix;
    }
}
