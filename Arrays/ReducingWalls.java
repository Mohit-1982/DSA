GFG
  Brute : 
    class Solution {
    public int reducingWalls(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        int opr = 0;
        while(pq.peek() > k) {
            opr++;
            pq.add(pq.remove() - k);
        }
        return opr;
    }
}
Optimal : 
  class Solution {
    public int reducingWalls(int[] arr, int k) {
        int i = 0;
        int n = arr.length;
        int opr = 0;
        while(i < n) {
            if(arr[i] > k) {
                opr++;
                arr[i] -= k;
                if(arr[i] <= k) i++; 
            }else {
                i++;
            }
        }
        return opr;
    }
}
