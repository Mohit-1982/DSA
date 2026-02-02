Leetcode - 1207
  class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : arr) {
            map.put(ele,map.getOrDefault(ele,0) + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int ele : map.values()) {
            if(set.contains(ele)) return false;
            set.add(ele);
        }
        //we can also return map.size() == set.size() 
        //as set will remove those values which don't have unique occurances
        return true;
    }
}
