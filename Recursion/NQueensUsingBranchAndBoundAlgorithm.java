import java.util.Scanner;

public class NQueen {
    public static void main(String[] args) {
        System.out.println("Enter the Length of Chess Board : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] chess = new boolean[n][n];
        boolean[] cols = new boolean[n];
        boolean[] normalDiagonal = new boolean[2 * n - 1];
        boolean[] reverseDiagonal = new boolean[2 * n - 1];
        nRaani(chess,cols,normalDiagonal,reverseDiagonal,"",0);
    }
    //   BRANCH AND BOUND ALGORITHM
    static void nRaani(boolean[][] chess,boolean[] cols,boolean[] nrmlDia,boolean[] rDia,String p,int row) {
        //Base Case
        if(row == chess.length) {
            System.out.println(p + " ");
            return;
        }
        // Traverse column wise
        for(int col = 0;col < chess.length;col++) {
            if(cols[col] == false && nrmlDia[row + col] == false && rDia[row - col + chess.length - 1] == false) {
                //place the queen
                chess[row][col] = true;
                cols[col] = true;
                nrmlDia[row + col] = true;
                rDia[row - col + chess.length - 1] = true;
                nRaani(chess,cols,nrmlDia,rDia,p + row + '-' + col + " ",row + 1);
                //BackTracking --> Remove all the changes made (make everything false which we maked true)
                chess[row][col] = false;
                cols[col] = false;
                nrmlDia[row + col] = false;
                rDia[row - col + chess.length - 1] = false;
            }
        }
    }
}
