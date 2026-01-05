class Solution {
    int countPairs(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++) {
            if(map.containsKey(arr[i])) {
                int freq = map.get(arr[i]);
                map.put(arr[i],freq + 1);
            }else map.put(arr[i],1);
        }
        int pairs = 0;
        for(int ele : map.keySet()) {
            int remaining = ele - k;
            int rem2 = k + ele;
            if(map.containsKey(remaining)) pairs += map.get(remaining)*map.get(ele);
            if(map.containsKey(rem2)) pairs += map.get(rem2)*map.get(ele);//multiplied frequencies of both/
        }
        return pairs/2;
    }
}
