Leetcode - 1020
  class Solution {
    public int numEnclaves(int[][] grid) {
        //solve using bfs
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < m; i++) {
            if(!vis[0][i] && grid[0][i] == 1) dfs(grid, vis, 0, i);
            if(!vis[n - 1][i] && grid[n - 1][i] == 1) dfs(grid, vis, n - 1, i);
        }

        for(int i = 0; i < n; i++) {
            if(!vis[i][0] && grid[i][0] == 1) dfs(grid, vis, i, 0);
            if(!vis[i][m - 1] && grid[i][m - 1] == 1) dfs(grid, vis, i, m - 1);
        }

        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j] && grid[i][j] == 1) count++;
            }
        }

        return count;
    }
    
    public void dfs(int[][] grid, boolean[][] vis, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || vis[row][col] || grid[row][col] == 0) return;

        vis[row][col] = true;
        dfs(grid, vis, row + 1, col);
        dfs(grid, vis, row - 1, col);
        dfs(grid, vis, row, col + 1);
        dfs(grid, vis, row, col - 1);
    }
}
