class Solution {
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        int flag = 0;
        for(int i = 0;i < n;i++) {
            for(int j = 1;j < n - i;j++) {
                if(arr[j] < arr[j - 1]) {
                    //swap
                    flag = 1;
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
            //Optimized a bit
            if(flag == 1) {
                    flag = 0;
                }else {
                    return;
                }
        }
    }
}

//Recursive version
    class Solution {
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int[] count = new int[1];
            sort(arr, 0, count, i);
            if (count[0] == 0) break;
        }
    }
    public void sort(int[] arr, int i, int[] count, int n) {
        if (i == arr.length - n - 1) return;
        if (arr[i] > arr[i + 1]) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
            count[0]++;
        }
        sort(arr, i + 1, count, n);
    }
}
