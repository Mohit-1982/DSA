GFG

class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        ArrayList<Double> list = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++) {
            if(maxHeap.size() == 0) maxHeap.add(arr[i]);
            else {
                if(arr[i] < maxHeap.peek()) maxHeap.add(arr[i]);
                else minHeap.add(arr[i]);
            }
            
            if(maxHeap.size() == minHeap.size() + 2) minHeap.add(maxHeap.remove());
            if(minHeap.size() == maxHeap.size() + 2) maxHeap.add(minHeap.remove());
            
            if(maxHeap.size() == minHeap.size()) {
                list.add((maxHeap.peek() + minHeap.peek())/2.0);
            }else {
                if(maxHeap.size() > minHeap.size()) list.add(maxHeap.peek()/1.0);
                else list.add(minHeap.peek()/1.0);
            }
        }
        return list;
    }
}
