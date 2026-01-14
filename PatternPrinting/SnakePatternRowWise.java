package Pattern;

public class SnakePrint {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4,5},
                {10,9,8,7,6},
                {11,12,13,14},
                {20,19,18,17,16},
                {21,22,23,24,25},
        };
        printSnake2(arr);
    }
    //bad approach will fail in case row and coloumn length of all array is differnt and now much readable
    static void printSnake(int[][] arr) {
        int col = 0;
        for(int row = 0;row < arr.length; row++) {
            if(col == 0) {
                while(col < arr[0].length) {
                    System.out.print(arr[row][col] + " ");
                    col++;
                }
                col--;
                System.out.println();
            }else {
                while(col >= 0) {
                    System.out.print(arr[row][col] + " ");
                    col--;
                }
                col++;
                System.out.println();
            }
        }
    }
    //good approach
    static void printSnake2(int[][] arr) {
        for(int i = 0;i < arr.length; i++) {
            if(i % 2 == 0) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }else {
                for (int j = arr[i].length - 1; j >= 0; j--) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
