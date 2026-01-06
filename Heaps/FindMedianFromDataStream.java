Leetcode - 295

class MedianFinder {
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> min = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(max.size() == 0 && min.size() == 0) max.add(num); 
        else {
            if(num < max.peek()) max.add(num);
            else min.add(num);
        }
        if(max.size() == min.size() + 2) min.add(max.remove());
        if(min.size() == max.size() + 2) max.add(min.remove());
    }
    
    public double findMedian() {
        if(max.size() == min.size() + 1) return max.peek();
        else if(min.size() == max.size() + 1) return min.peek();
        else return (max.peek() + min.peek()) / 2.0;//convert into double as return type is double.
    }
}
