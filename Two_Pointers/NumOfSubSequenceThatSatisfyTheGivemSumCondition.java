Leetcode - 1498
  Brute : 
    class Solution {
    public int numSubseq(int[] nums, int target) {
        List<List<Integer>> store = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        genAllSubse(nums, store, list, 0);
        int count = 0;
        for(List<Integer> thing : store) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            if(thing.isEmpty()) continue; //this will skip the empty case
            for(int ele : thing) {
                max = Math.max(ele, max);
                min = Math.min(ele, min);
            }
            if(max + min <= target) count++;
        }
        return (count) % 1000000007;
    }
    public void genAllSubse(int[] arr, List<List<Integer>> res, List<Integer> list, int idx) {
        if(idx >= arr.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        //pick
        list.add(arr[idx]);
        genAllSubse(arr, res, list, idx + 1);
        //BackTracking
        list.remove(list.size() - 1);
        //skip
        genAllSubse(arr, res, list, idx + 1);
    }
}
Optimal : 
  class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int M = (int) 1e9 + 7;
        int n = nums.length;
        int res = 0;
        int l = 0;
        int r = n - 1;
        int[] power = new int[n];
        power[0] = 1;
        for(int i = 1; i < n; i++) {
            power[i] = 2 * power[i - 1] % M;//Why % M as it can Int Overflow
        }
        while(l <= r) {
            int pairSum = nums[l] + nums[r];
            if(pairSum > target) r--;
            else {
                int diff = r - l;
                res =  (res + power[diff]) % M;
                l++;
            }
        }
        return res;
    }
}
