Leetcode - 239
  Approach 1 : Tc -- O(nk) gives TLE
    class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int l = 0;
        int[] ans = new int[n-k+1];
        for(int i = 0;i<=n-k;i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i;j<k+i;j++) {
                max = Math.max(arr[j],max);
            }
            ans[l++] = max;
        }
        return ans;
    }
}

Approach 2 : TC -- O(n)    SC -- O(k)
class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> q = new ArrayDeque<>();
        int[] ans = new int[n-k+1];
        int l = 0;
        for(int i = 0;i<k-1;i++) {
            if(q.isEmpty()) q.addLast(i);
            else {
                while(!q.isEmpty() && arr[i] > arr[q.peekLast()]) {
                    q.removeLast();
                }
                q.addLast(i);
            }
        }
        for(int i = k-1;i<n;i++) {
            while(!q.isEmpty() && arr[i] > arr[q.peekLast()]) {
                q.removeLast();
            }
            q.addLast(i);
            if(q.peekFirst() <= i-k) q.removeFirst();
            ans[l++] = arr[q.peekFirst()];
        }
        return ans;
    }
}
