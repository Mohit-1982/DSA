Leetcode - 338
  Brute :
    class Solution {
    public int[] countBits(int n) {
        //O(nlogn)
        int[] arr = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            int j = i;
            int count = 0;
            while(j != 0) {
                count += (j & 1);
                j >>= 1;
            }
            arr[i] = count;
        }
        return arr;
    }
}

Optimal : 
  
