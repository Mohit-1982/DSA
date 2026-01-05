Leetcode - 658


//Instead of this return this.val - t.val; we can use Integer.compare(this.diff,t.diff);

class Pair implements Comparable<Pair>{
    int diff;
    int val;
    Pair(int diff,int val) {
        this.diff = diff;
        this.val = val;
    }
    //custom comparator
    // public int compareTo . this should exact look like this otherwise it will show compile time error the name compareTo itseld should be like this.
    public int compareTo(Pair t) {
        if(this.diff == t.diff) return this.val - t.val;
        return this.diff - t.diff;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < arr.length; i++) {
            int diff = x - arr[i];
            if(diff < 0) diff *= -1;
            pq.add(new Pair(diff,arr[i]));
            if(pq.size() > k) pq.remove();
        }
        for(int i = 0;i<k;i++) {
            Pair top = pq.remove();
            ans.add(top.val);
        }
        Collections.sort(ans);
        return ans;
    }
}
