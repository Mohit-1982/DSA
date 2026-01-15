GFG
  class Solution {
    public boolean canSplit(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for(int i = 0;i < n;i++) {
            sum += arr[i];
        }
        int prefix = 0;
        for(int i = 0;i < n;i++) {
            prefix += arr[i];
            if(prefix == sum - prefix) return true;
        }
        return false;
    }
}
