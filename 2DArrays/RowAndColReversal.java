package Pattern;

public class ReverseRowAndColOfMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {  1,  0, -1,  2 },
                {  5,  5,  5,  5 },
                { -3,  8,  0,  9 }
        };
//        printRowReverse(arr);
        printColoumnReverse(arr);
        for(int[] ele : arr) {
            for(int thing : ele) {
                System.out.print(thing + " ");
            }
            System.out.println();
        }
    }
    static void printRowReverse(int[][] arr) {
        if(arr == null || arr.length == 0) return;
        for (int row = 0; row < arr.length; row++) {
            int i = 0;
            int j = arr[row].length - 1; //this will print even for zig zag array
            while(i < j) {
                int temp = arr[row][i];
                arr[row][i] = arr[row][j];
                arr[row][j] = temp;
                i++;
                j--;
            }
        }
    }
    static void printColoumnReverse(int[][] arr) {
        if(arr == null || arr.length == 0) return;
        for (int col = 0; col < arr[0].length; col++) {
            int i = 0;
            int j = arr.length - 1;
            while(i < j) {
//                if(col < arr[j].length && col < arr[i].length) for jagged(zig zag) array defensive case
                int temp = arr[i][col];
                arr[i][col] = arr[j][col];
                arr[j][col] = temp;
                i++;
                j--;
            }
        }
    }
}
