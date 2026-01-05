Approach 1 : 

Tc -- > (n + K) logn it is more than sorting thats why we are going to use maxHeap.
  
class Solution {
    public int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<arr.length;i++) {
            pq.add(arr[i]);
        }
        for(int i = 0;i<k-1;i++) {
            pq.remove();
        }
        return pq.peek();
    }
}

Approach 2 : 

Tc -- > O(nlogk)

  class Solution {
    public int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<arr.length;i++) {
            pq.add(arr[i]);
            if(pq.size() > k) pq.remove();
        }
        return pq.peek();
    }
}
