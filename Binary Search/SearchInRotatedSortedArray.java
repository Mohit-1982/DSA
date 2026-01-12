Leetcode - 33
  Brute - O(n) :

class Solution {
    public int search(int[] nums, int target) {
        for(int i = 0;i< nums.length;i++) {
            if(nums[i] == target) return i; 
        }
        return -1;
    }
}

Optimal Using BS : O(logn) :
 class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while(s <= e) {
            int m = s + (e-s)/2;
            if(nums[m] == target) {
                return m;
            }
            else if(nums[m] >= nums[s]) {//left sorted
                if(nums[m] >= target && nums[s] <= target) {
                    e = m - 1;
                }else {
                    s = m + 1;
                }
            }else {//right sorted
                if(nums[m] <= target && nums[e] >= target) {
                    s = m + 1;
                }else {
                    e = m - 1;
                }
            }
        }
        return -1;
    }
}
