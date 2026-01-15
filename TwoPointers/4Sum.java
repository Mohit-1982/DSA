Leetcode - 18
  Brute : O(n^4 * logm) Using hashset and 4 nested loops
    class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4) return new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();

        for(int i = 0;i<nums.length;i++) {
            for(int j = i+1;j<nums.length;j++) {
                for(int k = j+1;k<nums.length;k++) {
                    for(int l = k+1;l<nums.length;l++) {
                        if(nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[l]);
                            Collections.sort(list);
                            set.add(list);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}

Better :
  O(n^3 logn) Using Hashset Array.sort Binary Search 3 Nested loops
    class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //hashset + binary search + 3 pointers
        Arrays.sort(nums);
        if(nums.length < 4) return new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
         for(int i = 0;i<nums.length;i++) {
            for(int j = i+1;j<nums.length;j++) {
                for(int k = j+1;k<nums.length;k++) {
                    long rem = (long)target - nums[i] - nums[j] - nums[k];
                    int s = k+1;
                    int e = nums.length - 1;
                    while(s <= e) {
                        int m = s + (e - s) / 2;
                        if((long)nums[m] == rem) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[m]);
                            set.add(list);
                            break;
                        }else if((long)nums[m] > rem) e = m - 1;
                        else s = m + 1;
                    }
                }
            }
         }
         return new ArrayList<>(set);
    }
}

Optimal :
  
