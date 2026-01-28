Leetcode - 36
  class Solution {
    public boolean isValidSudoku(char[][] board) {
        return validBoard(board,0,0);
    } 
    public boolean validBoard(char[][] board,int row,int col) {
        if(row == board.length) return true;

        if(col >= board[0].length) {
            return validBoard(board,row + 1,0);
        }

        if(board[row][col] == '.') {
            return validBoard(board,row,col + 1);
        }

        if(isValid(board,row,col)) {
            return validBoard(board,row,col + 1);
        }else {
            return false;
        }
    }
    public boolean isValid(char[][] board,int row,int col) {
        char val = board[row][col];

        //row check
        for(int i = 0;i < board.length;i++) {
            if(i != row && board[i][col] == val) {//i != row this check wheater we are on our own idx or not 
                return false;
            }
        }

        //colomn check
        for(int i = 0;i < board[0].length;i++) {
            if(i != col && board[row][i] == val) {//i != col this check wheater we are on our own idx or not 
                return false;
            }
        }

        //matrix check
        int x = (row / 3) * 3;
        int y = (col / 3) * 3;
        for(int i = 0;i < 3;i++) {
            for(int j = 0;j < 3;j++) {
                int r = x + i;
                int c = y + j;
                if(row != r && col != c && board[r][c] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
