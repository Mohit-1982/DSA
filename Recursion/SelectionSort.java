package ARECURSION.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {-1,1,-4,9,8,9,7,67,9,34,2,1,4};
        selection(arr,0);
        for(int ele : arr) System.out.print(ele+" ");
    }
    static void selection(int[] arr,int i){
        if(i == arr.length-1 || arr.length == 0) return;
        int max = arr[0];
        int idx = 0;
        for(int k = 1;k<arr.length-i;k++){
            if(arr[k] > max) {
                max = arr[k];
                idx = k;
            }
        }
        int temp = arr[arr.length-i-1];
        arr[arr.length-i-1] = arr[idx];
        arr[idx] = temp;
        selection(arr,i+1);
    }
}
