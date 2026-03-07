Leetcode - 2786
  Brute :
    class Solution {
    public long maxScore(int[] nums, int x) {
        //Parity --> 0 - even, 1 - odd
        int parity = nums[0] % 2;
        return helper(nums, x, parity, 0, 0);
    }
    public long helper(int[] arr, int x, int prevParity, int i, long score) {
        if(i >= arr.length) {
            return score;
        }
        int parity = arr[i] % 2;
        long pick = -1;
        if((parity == 0 && prevParity == 1) || (parity == 1 && prevParity == 0)) {
            pick = helper(arr, x, parity, i + 1, score - x + arr[i]);
        }else {
            pick = helper(arr, x, parity, i + 1, score + arr[i]);
        }
        long skip = helper(arr, x, prevParity, i + 1, score);
        long ans = Math.max(pick, skip);
        return ans;
    }
}

Optimal : 
  *Memoization : 
    
