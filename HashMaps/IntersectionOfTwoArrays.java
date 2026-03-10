Leetcode - 
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // hashset + merge two arrays logic
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], 1);
        }
        for(int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i])) {
                int freq = map.get(nums2[i]);
                map.put(nums2[i], freq + 1);
            }
        }
        int k = 0;
        for(int ele : map.keySet()) {
            if(map.get(ele) > 1) k++;
        }
        int[] arr = new int[k];
        k = 0;
        for(int ele : map.keySet()) {
            if(map.get(ele) > 1) arr[k++] = ele;
        }
        return arr;
    }
}
