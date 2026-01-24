Leetcode - 52
  class Solution {
    public int totalNQueens(int n) {
        return solveNQueens(n);
    }
    public int solveNQueens(int n) {
        //Using Branch And Bound Algorithm
        boolean[][] board = new boolean[n][n];
        boolean[] cols = new boolean[n];
        boolean[] ndia = new boolean[2 * n - 1];
        boolean[] rdia = new boolean[2 * n - 1];
        return NRaani(board,cols,ndia,rdia,0);
    }
    public int NRaani(boolean[][] board,boolean[] c,boolean[] ndia,boolean[] rdia,int row) {
        if(row == board.length) {
            return 1;
        }
        int ans = 0;
        for(int col = 0;col < board.length;col++) {
            if(c[col] == false && ndia[row + col] == false && rdia[row - col + board.length - 1] == false && board[row][col] == false) {
                board[row][col] = true;
                c[col] = true;
                ndia[row + col] = true;
                rdia[row - col + board.length - 1] = true;
                ans += NRaani(board,c,ndia,rdia,row + 1);
                board[row][col] = false;
                c[col] = false;
                ndia[row + col] = false;
                rdia[row - col + board.length - 1] = false;
            }
        }
        return ans;
    }
}
