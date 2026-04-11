Leetcode - 1254
  class Solution {
    public int closedIsland(int[][] grid) {
        //Boundary Elimination Pattern
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < m; i++) {
            if(!vis[0][i] && grid[0][i] == 0) {
                dfs(grid, vis, 0, i);
            }
            if(!vis[n - 1][i] && grid[n - 1][i] == 0) {
                dfs(grid, vis, n - 1, i);
            }
        }

        for(int i = 0; i < n; i++) {
            if(!vis[i][0] && grid[i][0] == 0) {
                dfs(grid, vis, i, 0);
            }
            if(!vis[i][m - 1] && grid[i][m - 1] == 0) {
                dfs(grid, vis, i, m - 1);
            }
        }

        int island = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j] && grid[i][j] == 0) {
                    dfs(grid, vis, i, j);
                    island++;
                }
            }
        }

        return island;
    }

    public void dfs(int[][] grid, boolean[][] vis, int row, int col) {
        int n = grid.length;
        int m = grid[0].length;

        if(row < 0 || col < 0 || row >= n || col >= m || vis[row][col] || grid[row][col] == 1) return;

        vis[row][col] = true;
        dfs(grid, vis, row + 1, col);
        dfs(grid, vis, row - 1, col);
        dfs(grid, vis, row, col + 1);
        dfs(grid, vis, row, col - 1);
    }
}
