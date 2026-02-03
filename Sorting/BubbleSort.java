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
