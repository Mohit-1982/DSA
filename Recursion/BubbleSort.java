package ARECURSION.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 7, 5, 7, 3, 9};
        bubbleSort(arr, 0, 0);
        for (int ele : arr) System.out.print(ele + " ");
    }

    static void bubbleSort(int[] arr, int i, int j) {
        if (i == arr.length) return;
        if (j == arr.length - i - 1) {
            bubbleSort(arr, i + 1, 0);
            return;
        }
        if (arr[j] > arr[j + 1]) {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        }
        bubbleSort(arr, i, j + 1);
        }
    }
