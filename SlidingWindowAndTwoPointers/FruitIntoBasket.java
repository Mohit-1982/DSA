Leetcode - 904

class Solution {
    public int totalFruit(int[] arr) {
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int k = 2;
        HashMap<Integer,Integer> map = new HashMap<>();

        while(r < arr.length) {
            if(map.containsKey(arr[r])) {
                int freq = map.get(arr[r]);
                map.put(arr[r],freq+1);
            }else map.put(arr[r],1);
            
            if(map.size() > k) {
                int freq = map.get(arr[l]) - 1;
                if(freq == 0) map.remove(arr[l]);
                else map.put(arr[l],freq);
                l++;
            }
            if(map.size() <= k) {
                maxLen = Math.max(maxLen,r-l+1);
            }
            r++;
        }
        return maxLen;
    }
}
