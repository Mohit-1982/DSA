package Pattern;

public class SnakePatternColoumnWise {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4,5},
                {10,9,8,7,6},
                {11,12,13,14},
                {20,19,18,17,16},
                {21,22,23,24,25},
        };
        printSnake1(arr);
    }
    static void printSnake1(int[][] arr) {
        for (int col = 0; col < arr[0].length; col++) {
            if(col % 2 == 0) {
                for (int row = 0; row < arr.length; row++) {
                    if(col < arr[row].length) {
                        System.out.print(arr[row][col] + " ");
                    }
                }
                System.out.println();
            }else {
                for (int row = arr.length - 1; row >= 0; row--) {
                    if(col < arr[row].length) {
                        System.out.print(arr[row][col] + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}
