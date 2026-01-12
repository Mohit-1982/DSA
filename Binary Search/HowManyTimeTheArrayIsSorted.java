GFG
  class Solution {
    public int findKRotation(int arr[]) {
        //To find how many time the array is sorted just find the 
        //minimum value index it will be our answer
        int s = 0;
        int e = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int idx = -1;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(min > arr[m]) {
                min = arr[m];
                idx = m;
            }
            if(arr[m] > arr[e]) {
                s = m + 1;
            }else {
                e = m - 1;
            }
        }
        return idx;
    }
}
