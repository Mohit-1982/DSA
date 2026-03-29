Leetcode - 26
  Brute : 
    class Solution {
    public int removeDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int ele : nums) {
            if(!set.contains(ele)) {
                list.add(ele);
            }
            set.add(ele);
        }
        for(int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return list.size();
    }
}
Optimal : 
  class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = i + 1;
        while(j < nums.length) {
            if(nums[i] == nums[j]) j++;
            else {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }
}
