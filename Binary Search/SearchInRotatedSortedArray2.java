Brute :
class Solution {
    public boolean search(int[] nums, int target) {
        for(int i = 0;i<nums.length;i++) {
            if(nums[i] == target) return true;
        }
        return false;
    }
}

Optimal : Tc -- Average O(logn)  Worst O(n/2) as if there are so many duplicates it will keep shrinking. 
class Solution {
    public boolean search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while(s <= e) {
            int m = s + (e-s)/2;
            if(nums[m] == target) {
                return true;
            }
            else if(nums[m] == nums[s] && nums[m] == nums[e]) {
                s = s + 1; //shrink the space till we get a search space to find the element.
                e = e - 1;
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
        return false;
    }
}
