Leetcode - 540
  Brute : O(n)
    class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[nums.length - 1] != nums[nums.length - 2]) return nums[nums.length - 1];
        for(int i = 1;i < nums.length-1; i++) {
            if(nums[i] != nums[i-1] && nums[i] != nums[i+1]) return nums[i];
        }
        return -1;
    }
}


Optimal : O(logn)
  class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[nums.length - 1] != nums[nums.length - 2]) return nums[nums.length - 1];
        int s = 1;
        int e = nums.length - 2;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(nums[m] != nums[m + 1] && nums[m] != nums[m - 1]) {
                return nums[m];
            }else if((m%2 == 1 && nums[m-1] == nums[m]) || (m%2 == 0 && nums[m] == nums[m+1])) {//eliminate left half
                s = m + 1;
            }else { //eliminate right half
                e = m - 1;
            }
        }
        return -1;
    }
}
