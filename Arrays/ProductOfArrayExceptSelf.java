Leetcode - 238
  Brute : 
    class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int add = 1;
            for(int j = 0; j < nums.length; j++) {
                if(i != j) {
                    add *= nums[j];
                }
            }
            arr[i] = add;
        }
        return arr;
    }
}
Better :   
  class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = prefix(nums);
        int[] suffix = suffix(nums);
        for(int i = 0; i < nums.length; i++) {
            nums[i] = prefix[i] * suffix[i];
        }
        return nums;
    }
    public int[] prefix(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = 1;
        for(int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] * arr[i - 1];
        }
        return prefix;
    }
    public int[] suffix(int[] arr) {
        int[] suffix = new int[arr.length];
        suffix[suffix.length - 1] = 1;
        for(int i = suffix.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * arr[i + 1];
        }
        return suffix;
    }
}

Optimal : 
  class Solution {
    //TRY THIS AGAIN
    public int[] productExceptSelf(int[] nums) {
        //find prefix sum
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }

        //using a variable product calculate suffix sum at each interval
        int prd = 1;
        for(int j = nums.length - 1; j >= 0; j--) {
            if(j == nums.length - 1) {
                prefix[j] = prefix[j - 1];
            }else if(j == 0) {
                prefix[0] = prd;
            }else {
                prefix[j] = prefix[j - 1] * prd;
            }
            prd *= nums[j];
        }
        return prefix;
    }
}
