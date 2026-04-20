GFG
  class Solution {
    void mergeSort(int arr[], int l, int r) {
        //Divide and Conqueror Algorithm
        int n = arr.length;
        sort(arr);
    }
    
    void sort(int[] arr) {
        
        int k = 0;
        int n = arr.length;
        if (n == 1) return;
        int[] a = new int[n / 2];
        int[] b = new int[n - n / 2];
        
        for (int i = 0; i < a.length; i++) {
            a[i] = arr[k++];
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = arr[k++];
        }
        
        sort(a);
        sort(b);
        merge(arr, a, b);
    } 
    
    void merge(int[] arr, int[] a, int[] b) {
        //we can also create here a new array and then works with
        //only pointers like start mid end to sort the array
        //In this approach we are not creating a new array always in sort a and b
        //instead we just play with indexes
        int i = 0;
        int j = 0;
        int k = 0;
        int n = a.length; 
        int m = b.length;
        
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                arr[k++] = a[i++];
            }else {
                arr[k++] = b[j++];
            }
        }
        
        while (i < n) {
            arr[k++] = a[i++];
        }
        while (j < m) {
            arr[k++] = b[j++];
        }
    }
}
