GFG 
  TC : O(nlogn)

  class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int s = 1;
        int e = stalls[stalls.length - 1] - stalls[0];//as the array is sorted no need to find max
        
        int res = -1;
        
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(canBePlaced(stalls,m,k)) {
                res = m;
                s = m + 1;
            }else {
                e = m - 1;
            }
        }
        return res;
    }
    public boolean canBePlaced(int[] arr,int dist,int cows) {
        int count = 1;
        int last = arr[0];
        for(int i = 1;i < arr.length;i++) {
            if(arr[i] - last >= dist) {
                count++;
                last = arr[i];
            }
            if(count >= cows) return true;
        }
        return false;
    }
}
