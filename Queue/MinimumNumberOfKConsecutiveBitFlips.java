Leetcode - 995

  Brute Force - O(nk) :

class Solution {
    public int minKBitFlips(int[] arr, int k) {
        int n = arr.length;
        int flip = 0;
        for(int i = 0; i < n-k+1; i++) {
            if(arr[i] == 0) {
                for(int j = i; j < k+i; j++) {
                    if(arr[j] == 0) {
                        arr[j] = 1;
                    }else arr[j] = 0;
                }
                flip++;
            }
        }
        for(int i = 0;i < n;i++) {
            if(arr[i] == 0) return -1;
        }
        return flip;
    }
}

OPtimal Approach : TC -- O(n)   SC -- O(k)

  class Solution {
    public int minKBitFlips(int[] arr, int k) {
        int n = arr.length;
        int flip = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(!q.isEmpty() && i > q.peek()) q.remove();
                if(q.size() % 2 == arr[i]) {//we need to flip
                    if(i+k-1 >= n) return -1; 
                    q.add(i+k-1);
                    flip++;
                }
            }
            return flip;
        }
    }

