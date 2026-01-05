class Solution {
    public static int minCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<arr.length;i++) {
            pq.add(arr[i]);
        }
        int cost = 0;
        while(pq.size() > 1) {
            int num = pq.remove() + pq.remove();
            cost += num;
            pq.add(num);
        }
        return cost;
    }
}
