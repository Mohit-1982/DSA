Leetcode - 3745
  Brute : 
    class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int n = nums.length;
        int maxIdx = -1;
        int secMaxIdx = -1;
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            if(nums[i] > max) {
                secMax = max;
                secMaxIdx = maxIdx;
                max = nums[i];
                maxIdx = i;
            }else if(nums[i] <= max && secMax < nums[i]) {
                secMax = nums[i];
                secMaxIdx = i;
            }
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] < smallest && i != maxIdx && i != secMaxIdx) {
                smallest = nums[i];
            }
        }

        return max + secMax - smallest;
    }
}

Optimal :   
class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int n = nums.length;
        int max = -101;
        int secMax = -101;
        int min = 101;

        for(int num : nums) {
            if(num > max) {
                secMax = max;
                max = num;
            }else if(num <= max && num > secMax) {
                secMax = num;
            }
            min = Math.min(min, num);
        }

        return max + secMax - min;
        /* Arrays.sort(nums);
        return arr[n - 1] + arr[n - 2] - arr[0];
        */
    }
}
