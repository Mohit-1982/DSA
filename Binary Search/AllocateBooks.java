GFG        TC : O(n * log(sum - max))

  class Solution {
    public int findPages(int[] arr, int k) {
        int sum = 0;
        int max = -1;
        if(arr.length < k) return -1;
        for(int i = 0;i < arr.length;i++) {
            max = Math.max(arr[i],max);
            sum += arr[i];
        }
        int s = max;
        int e = sum;
        int res = -1;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(checkMin(arr,m,k)) {
                res = m;
                e = m - 1;
            }else {
                s = m + 1;
            }
        }
        return res; //else we can also return end......
    }
    public boolean checkMin(int[] arr,int pages,int students) {
        int ans = 1;
        int capacity = 0;
        for(int i = 0;i<arr.length;i++) {
            if(arr[i] + capacity > pages) {
                ans++;
                capacity = arr[i];
            }else {
                capacity += arr[i];
            }
            if(ans > students) return false; //means it will take more number of students thans k to allocate all the books 
        }
        return true;
    }
}
