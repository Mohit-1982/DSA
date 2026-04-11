Leetcode - 130
  WRONG CODE -->
    class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[] boundary = new boolean[1];
        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'X') continue;

                if(!vis[i][j]) {
                    boundary[0] = false;
                    dfs(board, vis, boundary, i, j);
                }
            }
        }
    }

    public void dfs(char[][] board, boolean[][] vis, boolean[] boundary, int row, int col) {

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || vis[row][col] || board[row][col] == 'X') return;

        if(row == 0 || col == 0 || row == board.length - 1 || col == board[0].length - 1) boundary[0] = true;

        vis[row][col] = true;
        dfs(board, vis, boundary, row + 1, col);
        dfs(board, vis, boundary, row - 1, col);
        dfs(board, vis, boundary, row, col + 1);
        dfs(board, vis, boundary, row, col - 1);

        if(!boundary[0]) board[row][col] = 'X';
    }
}

Correct : 
DFS:
  class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < m; i++) {
            //0th row
            if(!vis[0][i] && board[0][i] == 'O') {
                dfs(board, vis, 0, i);
            }
            //Last Row
            if(!vis[n - 1][i] && board[n - 1][i] == 'O') {
                dfs(board, vis, n - 1, i);
            }
        }

        for(int i = 0; i < n; i++) {
            //0th col
            if(!vis[i][0] && board[i][0] == 'O') {
                dfs(board, vis, i, 0);
            }
            //Last col
            if(!vis[i][m - 1] && board[i][m - 1] == 'O') {
                dfs(board, vis, i, m - 1);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void dfs(char[][] board, boolean[][] vis, int row, int col) {
         if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || vis[row][col] || board[row][col] == 'X') return;

        vis[row][col] = true;
        dfs(board, vis, row + 1, col);
        dfs(board, vis, row - 1, col);
        dfs(board, vis, row, col + 1);
        dfs(board, vis, row, col - 1);
    }
}

BFS:
  class Pair{
    int row;
    int col;
    
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();

        //Fill the Queue with all boundary O's
        for(int i = 0; i < m; i++) {
            //0th row
            if(!vis[0][i] && board[0][i] == 'O') {
                q.add(new Pair(0, i));
                vis[0][i] = true;
            }
            //Last row
            if(!vis[n - 1][i] && board[n - 1][i] == 'O') {
                q.add(new Pair(n - 1, i));
                vis[n - 1][i] = true;
            }
        }

        for(int i = 0; i < n; i++) {
            //0th col
            if(!vis[i][0] && board[i][0] == 'O') {
                q.add(new Pair(i, 0));
                vis[i][0] = true;
            }
            //Last col
            if(!vis[i][m - 1] && board[i][m - 1] == 'O') {
                q.add(new Pair(i, m - 1));
                vis[i][m - 1] = true;
            }
        }

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while(!q.isEmpty()) {
            //Explore all the Neighbours with O and mark them visited
            Pair front = q.remove();
            int row = front.row;
            int col = front.col;

            for(int i = 0; i < 4; i++) {
                int nRow = row + dr[i];
                int nCol = col + dc[i];

                if(nRow >= 0 && nCol >= 0 && nRow < n && nCol < m && !vis[nRow][nCol] && board[nRow][nCol] == 'O') {
                    q.add(new Pair(nRow, nCol));
                    vis[nRow][nCol] = true;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
