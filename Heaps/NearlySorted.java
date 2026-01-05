Tc -- > O(nlogk)
Sc -- > O(k)
class Solution {
    public void nearlySorted(int[] arr, int k) {
        int l = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<arr.length;i++) {
            pq.add(arr[i]);
            if(pq.size() > k) {
                arr[l++] = pq.remove();
            }
        }
        for(int i = 0;i<k;i++) {
            arr[l++] = pq.remove();
        }
    }
}
