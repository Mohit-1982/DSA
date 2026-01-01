public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4,6,2,5,7,9,1,3};
        quick(arr,0,arr.length-1);
        for(int ele : arr) System.out.print(ele + " ");
    }

    static void quick(int[] arr,int low,int high){
        if(low<high) {
            int partition = fun(arr, low, high);
            quick(arr, low, partition - 1);
            quick(arr, partition + 1, high);
        }
    }

    static int fun(int[] arr,int low,int high){
        int i = low;
        int j = high;
        int pivot = arr[low];
        while(i<j){
            while(i<=high-1 && pivot >= arr[i]) i++;
            while(j>=low+1 && pivot < arr[j])  j--;
            if(i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,low,j);
        return j;
    }
    static void swap(int[] arr,int low,int j){
            int temp = arr[low];
            arr[low] = arr[j];
            arr[j] = temp;
    }
}
