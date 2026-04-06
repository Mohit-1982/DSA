Leetcode - 79
  class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(dfs(board, word, 0, i, j)) return true;
            }
        }

        return false;
    }
    public boolean dfs(char[][] board, String str, int i, int row, int col) {
        if(i == str.length()) return true;

        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '1') return false;

        char ch = board[row][col];
        if(board[row][col] == str.charAt(i)) {
            board[row][col] = '1';
            if(dfs(board, str, i + 1, row + 1, col)) return true;
            if(dfs(board, str, i + 1, row - 1, col)) return true;
            if(dfs(board, str, i + 1, row, col + 1)) return true;
            if(dfs(board, str, i + 1, row, col - 1)) return true;
        }
        board[row][col] = ch;
        return false;
    }
}
