Leetcode - 169

  Approach 1 : Using HashMaps Tc --> n   Sc --> n

    class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : nums) {
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        int maxFreq = 0;
        int element = 0;
        for(int ele : map.keySet()) {
            if(map.get(ele) > maxFreq) {
                maxFreq = map.get(ele);
                element = ele;
            }
        }
        return element;
    }
}

Approach 2 : Boyer Moore Voting Algorithm 
  Tc --> n   Sc --> Constant

  class Solution {
    public int majorityElement(int[] nums) {
        int ele = 0;
        int count = 0;
        //Finding Candidate
        for(int i = 0;i<nums.length;i++) {
            if(count == 0) {
                ele = nums[i];
                count = 1;
            }
            else if(nums[i] == ele) {
                count++;
            }else {
                count--;
            }
        }
        //Veryfing Candidate
        int countFreq = 0;
        for(int i = 0;i<nums.length;i++) {
            if(nums[i] == ele) {
                countFreq++;
            }
        }
        if(countFreq > nums.length/2) return ele;
        else return -1;
    }
}
