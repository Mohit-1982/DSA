public class NQueens {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        nQueen(arr, 0, "");
    }

    static void nQueen(int[][] chess, int row, String p) {
        if(row == chess.length) {
            for(int[] ele : chess) {
                for(int thing : ele) {
                    System.out.print(thing + " ");
                }
                System.out.println();
            }
            System.out.println("Indices are : " + p);
            System.out.println();
            return;
        }
        //Queen Place
        for (int col = 0; col < chess.length; col++) { //we can only place one queen in one row that is why we are traversing coloumn wise
            if (isQueenSafe(row, col, chess)) {
                chess[row][col] = 1; //Queen Placed in this column
                nQueen(chess, row + 1, p + row + "-" + col + " "); //now check for other rows
                chess[row][col] = 0; //BackTrack (remove the queen from here because it is not a valid place)
            }
        }
    }
    static boolean isQueenSafe(int row,int col,int[][] chess) {
        //top check
        for(int i = row - 1;i >= 0; i--) { //here col remain same only row will decrease
            if(chess[i][col] == 1) {
                return false;
            }
        }
        //left top check
        for(int i = row - 1,j = col - 1; i >= 0 && j >= 0; i--,j--) {
            if(chess[i][j] == 1) {
                return false;
            }
        }
        //right top check
        for(int i = row - 1,j = col + 1; i >= 0 && j < chess.length; i--,j++) {
            if(chess[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
