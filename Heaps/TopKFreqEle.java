Leetcode - 347

class Pair implements Comparable<Pair>{
    int val;
    int freq;
    Pair(int val,int freq) {
        this.val = val;
        this.freq = freq;
    }
public int compareTo(Pair t) {
    if(this.freq == t.freq) return this.val - t.val;
    return this.freq - t.freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                int f = map.get(nums[i]);
                map.put(nums[i],f+1);
            }else map.put(nums[i],1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int ele : map.keySet()) {
            int f = map.get(ele);
            pq.add(new Pair(ele,f));
            if(pq.size() > k) pq.remove();
        }
        int[] arr = new int[k];
        int l = 0;
        while(pq.size() > 0) {
            Pair f = pq.remove();
            arr[l++] = f.val;
        }
        return arr;
    }
}
