GFG

  class Solution {
    public static long countKdivPairs(int arr[], int n, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0;i < arr.length; i++) {
            int enter = arr[i] % k;
            map.put(enter ,map.getOrDefault(enter,0) + 1);
        }
        
        long pairs = 0;
        //check for 0 remainder
        long zeroCount = map.getOrDefault(0,0);
        pairs += zeroCount * (zeroCount-1)/2;
        map.remove(0);
        //check for k%2 == k case
        if(k % 2 == 0 && map.containsKey(k/2)) {
            long countHalf = map.get(k/2);
            pairs += countHalf * (countHalf-1)/2;
            map.remove(k/2);
        }
        pairs *= 2;
        
        for(int ele : map.keySet()) {
            int rem = k - ele;
            if(map.containsKey(rem)) {
                pairs += (map.get(ele) * map.get(rem));
            }
        }
        return pairs/2;
    }
}
