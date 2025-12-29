GFG

class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        //first store indexes of elements smaller than zero(negative elements) in a queue
        for(int i = 0;i<n;i++){
            if(arr[i] < 0) q.add(i);
        }
        //loop till n-k+1 window
        for(int i = 0;i<n-k+1;i++){
            //check if -ve ele index is in the range of window or not
            while(q.size()>0 && q.peek()<i) q.remove();
            if(q.size()>0 && q.peek()<=i+k-1) ans.add(arr[q.peek()]);
            else ans.add(0);
        }
        return ans;
    }
}
