Leetcode - 37
  class Solution {
    public void solveSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        solver(board,0,0);
    }
    public boolean solver(char[][] board,int row,int col) {
        if(row == board.length) {
            display(board);
            return true;
        }
        if(col == board[0].length) {
            return solver(board,row + 1,0);
        }
        if(board[row][col] != '.') {
            return solver(board,row,col + 1);
        }
        else {
            for(int i = 1;i <= 9;i++) {
            char ch = (char)(i + '0');
            if(isOk(board,row,col,ch)) {
                board[row][col] = ch;
                if(solver(board,row,col + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }
          }
        }
        return false;
    }
    public boolean isOk(char[][] board,int row,int col,char val) {

        //row check
        for(int i = 0;i < board.length;i++) {
            if(board[row][i] == val) {
                return false;
            }
        }  

        //colomn check
        for(int i = 0;i < board[0].length;i++) {
            if(board[i][col] == val) {
                return false;
            }
        }

        //Matrix check
        int x = 3 * (row/3);//formula to find row and coloum of a matrix
        int y = 3 * (col/3);

        for(int i = 0;i < 3;i++) {
            for(int j = 0;j < 3;j++) {
                if(board[i + x][j + y] == val) {
                    return false;
                }
            }
        }
        return true;
    }
    public void display(char[][] board) {
        for(int i = 0;i < board.length;i++) {
            for(int j = 0;j < board[0].length;j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
