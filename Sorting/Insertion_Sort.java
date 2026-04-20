GFG
  class Solution {
    public void insertionSort(int arr[]) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                //shift towards right
                arr[j + 1] = arr[j];
                j--;
            }
            
            arr[j + 1] = key;
        }
    }
}

class Solution {
    public void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            sort(arr, i);
        }
    }
    
    public void sort(int[] arr, int i) {
        if (i <= 0 || arr[i] > arr[i - 1]) return;
        
        int temp = arr[i];
        arr[i] = arr[i - 1];
        arr[i - 1] = temp;
        
        sort(arr, i - 1);
    }
}
