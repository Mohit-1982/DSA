Leetcode - 977
  Optimal : 
    class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        int j = 0;
        //Find the element with first negative value
        int i = 0;
        for(i = 0; i < nums.length - 1; i++) {
            if(nums[i + 1] >= 0) {
                j = i;
                break;
            }
        }
        if(i >= nums.length - 1 && j == 0) j = nums.length - 1;
        //Square all the values
        for(i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i]; 
        }
        i = j + 1;
        int k = 0;
        //Place them on its correct position
        while(j >= 0 && i < nums.length) {
            if(nums[i] < nums[j]) arr[k++] = nums[i++];
            else arr[k++] = nums[j--];
        }
        while(j >= 0) arr[k++] = nums[j--];
        while(i < nums.length) arr[k++] = nums[i++];
        return arr;
    }
}
