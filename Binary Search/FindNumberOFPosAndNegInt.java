Leetcode - 2529
  Brute : 
    class Solution {
    public int maximumCount(int[] nums) {
        int neg = 0;
        int pos = 0;
        for(int ele : nums) {
            if(ele == 0) continue;
            if(ele < 0) neg++;
            else pos++;
        }
        return Math.max(neg,pos);
    }
}

Optimal : 
  class Solution {
    public int maximumCount(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int n = nums.length;
        //First Occurance
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(nums[m] >= 0) {
                e = m - 1;
            }else if(nums[m] < 0) {
                s = m + 1;
            }
        }
        int lastNeg = e;
        //Last Occurance
        s = 0;
        e = nums.length - 1;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(nums[m] <= 0) {
                s = m + 1;
            }else {
                e = m - 1;
            }
        }
        int firstPos = s;

        int neg = lastNeg + 1;
        int pos = n - firstPos;
        return Math.max(pos, neg); 
    }
}
  
