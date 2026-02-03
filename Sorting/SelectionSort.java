class Solution {
    void selectionSort(int[] arr) {
        int n = arr.length;
        int maxidx = 0;
        for(int i = 0;i < n - 1;i++) {
            //find max
            int lstIdx = n - i - 1;
            maxidx = 0;
            for(int j = 0;j <= lstIdx;j++) {
                if(arr[maxidx] < arr[j]) {
                    maxidx = j;
                }
            }
            //put it on its right place
            int temp = arr[lstIdx];
            arr[lstIdx] = arr[maxidx];
            arr[maxidx] = temp;
        }
    }
}
